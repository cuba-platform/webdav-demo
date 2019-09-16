package com.haulmont.demo.webdav.web.contractwdwithdefaultbehaviour;

import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.demo.webdav.entity.ContractWDWithDefaultBehaviour;
import com.haulmont.webdav.components.WebdavDocumentLink;

import javax.inject.Inject;

public class ContractWDWithDefaultBehaviourBrowse extends AbstractLookup {

    @Inject
    protected ComponentsFactory componentsFactory;

    public Component generateLinkCell(ContractWDWithDefaultBehaviour entity) {
        return componentsFactory.createComponent(WebdavDocumentLink.class)
                .withWebdavDocument(entity.getDocument());
    }
}