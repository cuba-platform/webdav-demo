package com.haulmont.contractsystem.web.contract;

import com.haulmont.contractsystem.entity.Contract;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.webdav.components.DocumentLink;
import com.haulmont.webdav.entity.WebdavDocumentVersion;
import com.haulmont.webdav.service.WebdavDocumentVersionsManagementService;

import javax.inject.Inject;

public class ContractBrowse extends AbstractLookup {

    @Inject
    protected ComponentsFactory componentsFactory;

    @Inject
    protected WebdavDocumentVersionsManagementService documentVersionsService;

    public Component generateLinkCell(Contract entity) {
        return componentsFactory.createComponent(DocumentLink.class)
                .withFileDescriptor(entity.getDocument());
    }

    public Component generateLatestVersionCell(Contract entity) {
        WebdavDocumentVersion latestVersion = documentVersionsService.retrieveLastVersionByFileDescriptorNN(
                entity.getDocument(), "webdavDocumentVersion-with-deps-view");

        return new Table.PlainTextCell(String.valueOf(latestVersion.getNaturalVersionId()));
    }
}