package com.haulmont.contractsystem.web.contract;

import com.haulmont.contractsystem.entity.Contract;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.webdav.components.DocumentLink;

import javax.inject.Inject;

public class ContractBrowse extends AbstractLookup {

    @Inject
    protected ComponentsFactory componentsFactory;

    public Component generateLinkCell(Contract entity) {
        return componentsFactory.createComponent(DocumentLink.class)
                .withFileDescriptor(entity.getDocument());
    }
}