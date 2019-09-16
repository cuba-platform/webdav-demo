package com.haulmont.demo.webdav.web.contractfdwithenabledwebdavenabledversioning;

import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.demo.webdav.entity.ContractFDWithEnabledWebdavEnabledVersioning;
import com.haulmont.webdav.components.WebdavDocumentLink;

import javax.inject.Inject;

public class ContractFDWithEnabledWebdavEnabledVersioningBrowse extends AbstractLookup {

    @Inject
    protected ComponentsFactory componentsFactory;

    public Component generateLinkCell(ContractFDWithEnabledWebdavEnabledVersioning entity) {
        return componentsFactory.createComponent(WebdavDocumentLink.class)
                .withFileDescriptor(entity.getDocument());
    }
}