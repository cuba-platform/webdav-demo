package com.haulmont.contractsystem.web.contractwithsimplefiledescriptor;

import com.haulmont.contractsystem.entity.ContractWithSimpleFileDescriptor;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.webdav.components.WebdavDocumentLink;

import javax.inject.Inject;

public class ContractWithSimpleFileDescriptorBrowse extends AbstractLookup {

    @Inject
    protected ComponentsFactory componentsFactory;

    public Component linkGenerator(ContractWithSimpleFileDescriptor contract) {
        return componentsFactory.createComponent(WebdavDocumentLink.class)
                .withFileDescriptor(contract.getFile());
    }
}