package com.haulmont.contractsystem.web.contractwdwithenabledversioning;

import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.contractsystem.entity.ContractWDWithEnabledVersioning;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.webdav.components.WebdavDocumentLink;

import javax.inject.Inject;

public class ContractWDWithEnabledVersioningBrowse extends AbstractLookup {

    @Inject
    protected ComponentsFactory componentsFactory;

    public Component generateLinkCell(ContractWDWithEnabledVersioning entity) {
        return componentsFactory.createComponent(WebdavDocumentLink.class)
                .withWebdavDocument(entity.getDocument());
    }
}