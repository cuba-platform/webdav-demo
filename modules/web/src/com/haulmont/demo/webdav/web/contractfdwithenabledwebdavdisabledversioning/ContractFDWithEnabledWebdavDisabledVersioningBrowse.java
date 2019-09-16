package com.haulmont.demo.webdav.web.contractfdwithenabledwebdavdisabledversioning;

import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.demo.webdav.entity.ContractFDWithEnabledWebdavDisabledVersioning;
import com.haulmont.webdav.components.WebdavDocumentLink;

import javax.inject.Inject;

public class ContractFDWithEnabledWebdavDisabledVersioningBrowse extends AbstractLookup {

    @Inject
    protected ComponentsFactory componentsFactory;

    public Component generateLinkCell(ContractFDWithEnabledWebdavDisabledVersioning entity) {
        return componentsFactory.createComponent(WebdavDocumentLink.class)
                .withFileDescriptor(entity.getDocument());
    }
}