package com.haulmont.contractsystem.web.contract;

import com.haulmont.contractsystem.entity.Contract;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.FileUploadField;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.webdav.service.WebdavDocumentsManagementService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

public class ContractEdit extends AbstractEditor<Contract> {

    @Inject
    protected WebdavDocumentsManagementService documentsService;

    @Inject
    protected Datasource<Contract> contractDs;

    @Named("fieldGroup.document")
    protected FileUploadField documentField;

    @Override
    public void init(Map<String, Object> params) {
        //documentField.addFileUploadSucceedListener(this::createWebdavEntities);
        //documentField.setClearButtonCaption("test");
        //documentField.setClearButtonIcon("icons/save.png");
        //documentField.setShowClearButton(true);
        documentField.setRequired(false);

    }

    protected void createWebdavEntities(FileUploadField.FileUploadSucceedEvent event) {
        documentsService.createDocumentByFileDescriptor(contractDs.getItem().getDocument());
    }
}