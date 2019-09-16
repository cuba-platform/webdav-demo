package com.haulmont.demo.webdav.web.contractwdwithdisabledversioning;

import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.demo.webdav.entity.ContractWDWithDisabledVersioning;
import com.haulmont.webdav.components.WebdavDocumentLink;

import javax.inject.Inject;

public class ContractWDWithDisabledVersioningBrowse extends AbstractLookup {

    @Inject
    protected ComponentsFactory componentsFactory;

    public Component generateLinkCell(ContractWDWithDisabledVersioning entity) {
        return componentsFactory.createComponent(WebdavDocumentLink.class)
                .withWebdavDocument(entity.getDocument());
    }
}