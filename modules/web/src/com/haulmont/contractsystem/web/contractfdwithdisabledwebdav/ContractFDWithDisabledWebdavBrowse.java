package com.haulmont.contractsystem.web.contractfdwithdisabledwebdav;

import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.contractsystem.entity.ContractFDWithDisabledWebdav;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.webdav.components.WebdavDocumentLink;

import javax.inject.Inject;

public class ContractFDWithDisabledWebdavBrowse extends AbstractLookup {

    @Inject
    protected ComponentsFactory componentsFactory;

    public Component generateLinkCell(ContractFDWithDisabledWebdav entity) {
        return componentsFactory.createComponent(WebdavDocumentLink.class)
                .withFileDescriptor(entity.getDocument());
    }
}