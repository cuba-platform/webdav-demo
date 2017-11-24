package com.haulmont.contractsystem.web.contract;

import com.haulmont.contractsystem.entity.Contract;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.webdav.components.WebdavDocumentLink;
import com.haulmont.webdav.components.WebdavDocumentVersionLink;
import com.haulmont.webdav.entity.WebdavDocument;
import com.haulmont.webdav.service.WebdavDocumentVersionsManagementService;
import com.haulmont.webdav.service.WebdavDocumentsManagementService;
import com.haulmont.webdav.webdav.component.WebWebdavDocumentLink;

import javax.inject.Inject;
import java.util.UUID;

public class ContractBrowse extends AbstractLookup {

    @Inject
    protected ComponentsFactory componentsFactory;

    @Inject
    protected WebdavDocumentsManagementService documentService;

    //protected WebdavDocumentLink documentLink;

    public Component generateLinkCell(Contract entity) {
        // UUID.fromString("380d2f08-85e8-74a2-9031-0ed7240791b0")
        WebdavDocument document = documentService.retrieveDocumentByFileDescriptorId(entity.getDocument().getId(), "webdavDocument-security");

        WebdavDocumentVersionLink documentVersionLink = componentsFactory.createComponent(WebdavDocumentVersionLink.class)
                .withDocument(document).withNaturalVersionId(1L);
//        documentVersionLink.setDocumentVersion(document.getLastVersion());
//        documentVersionLink.setDocument(document);
//        documentVersionLink.setNaturalVersionId(1);

        return documentVersionLink;
    }
    

//    public Component generateLinkCellId(Contract entity) {
//        return componentsFactory.createComponent(WebWebdavDocumentLink.class)
//                .withFileDescriptorId(entity.getDocument().getId());
//    }
//
//    public Component generateLinkCell2(Contract entity) {
//        WebdavDocumentLink documentLink = componentsFactory.createComponent(WebWebdavDocumentLink.class)
//                .withDocumentVersion(entity.getDocument());
//    }
//
//    public Component generateLinkCell2(Contract entity) {
//        WebdavDocumentLink documentLink = componentsFactory.createComponent(WebWebdavDocumentLink.class)
//                .withDocumentVersionId(UUID.randomUUID());
//    }

//    public Component generateLinkCell3(Contract entity) {
//        WebdavDocument webdavDocument = documentService.retrieveDocumentByFileDescriptorId(UUID.fromString());
//        WebdavDocumentLink documentLink = componentsFactory.createComponent(WebWebdavDocumentLink.class)
//                .withDocument(webdavDocument);
//    }

//    public Component generateLinkCell3(Contract entity) {
//        WebdavDocumentLink documentLink = componentsFactory.createComponent(WebWebdavDocumentLink.class)
//                .withDocumentId(entity.getDocument());
//    }

    public void onMutatorBtnClick() {
//        WebdavDocument webdavDocument = documentService.retrieveDocumentByFileDescriptorIdNN(UUID.fromString("380d2f08-85e8-74a2-9031-0ed7240791b0"));
//        documentLink.withDocument(webdavDocument);
    }
}