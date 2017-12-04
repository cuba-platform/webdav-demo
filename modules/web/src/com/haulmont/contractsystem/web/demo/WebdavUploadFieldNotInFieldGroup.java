package com.haulmont.contractsystem.web.demo;

import com.haulmont.contractsystem.entity.Contract;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
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

    @Override
    public void ready() {
        contractsDs.addItemChangeListener(e -> selectedItem.setValue("Selected: " + e.getItem()));
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