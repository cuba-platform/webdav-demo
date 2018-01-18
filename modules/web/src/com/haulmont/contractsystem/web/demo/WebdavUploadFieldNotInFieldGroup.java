package com.haulmont.contractsystem.web.demo;

import com.haulmont.contractsystem.entity.Contract;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.FileUploadField;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.webdav.components.WebdavDocumentVersionLink;
import com.haulmont.webdav.entity.WebdavDocument;
import com.haulmont.webdav.service.WebdavDocumentsManagementService;
import com.haulmont.webdav.webdav.component.WebWebdavDocumentLink;

import javax.inject.Inject;
import java.util.UUID;

public class WebdavUploadFieldNotInFieldGroup extends AbstractWindow {

    @Inject
    protected CollectionDatasource<Contract, UUID> contractsDs;

    @Inject
    protected ComponentsFactory componentsFactory;

    @Inject
    protected Label selectedItem;

    @Inject
    protected FileUploadField upload2;

    @Inject
    protected WebdavDocumentVersionLink documentVersionLink;

    @Inject
    protected WebdavDocumentsManagementService documentsService;

    @Override
    public void ready() {
        contractsDs.addItemChangeListener(e -> {
            if (e.getItem() == null) { return; }

            selectedItem.setValue("Selected: " + e.getItem());
            WebdavDocument document = documentsService.retrieveDocumentByFileDescriptor(contractsDs.getItem().getDocument());
            documentVersionLink.setIsUseLastVersion(true);
            documentVersionLink.setWebdavDocument(document);
        });
    }

    public void onSaveClick() {
        if (! validateAll()) {
            return;
        }
        getDsContext().commit();
    }

    public Component generateDocumentCell(Contract entity) {
        return componentsFactory.createComponent(WebWebdavDocumentLink.class)
                .withFileDescriptor(entity.getDocument());
    }
}