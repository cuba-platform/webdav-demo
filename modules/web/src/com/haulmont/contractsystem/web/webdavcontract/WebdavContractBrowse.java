package com.haulmont.contractsystem.web.webdavcontract;

import com.haulmont.contractsystem.entity.WebdavContract;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.webdav.components.WebdavDocumentLink;

import javax.inject.Inject;

public class WebdavContractBrowse extends AbstractLookup {

    @Inject
    protected ComponentsFactory componentsFactory;

    public Component generateDocumentCell(WebdavContract entity) {
        return componentsFactory.createComponent(WebdavDocumentLink.class)
                .withDocument(entity.getDocument());
    }
}