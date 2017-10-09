package com.haulmont.contractsystem.web.webdavdocumentversion;

import com.haulmont.contractsystem.entity.Contract;
import com.haulmont.cuba.gui.WindowParam;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.HBoxLayout;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.data.GroupDatasource;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.webdav.entity.WebdavDocument;
import com.haulmont.webdav.entity.WebdavDocumentVersion;
import com.haulmont.webdav.service.WebdavUrlManagementService;
import com.vaadin.server.Page;

import javax.inject.Inject;
import java.util.UUID;
import java.util.function.Consumer;

public class WebdavDocumentVersionDialogBrowse extends AbstractLookup {

    @Inject
    protected ExportDisplay exportDisplay;

    @Inject
    protected ComponentsFactory componentsFactory;

    @Inject
    protected GroupDatasource<WebdavDocumentVersion, UUID> webdavDocumentVersionsDs;

    @Inject
    protected WebdavUrlManagementService urlManagementService;


    public Component generateLinkCell(WebdavDocumentVersion entity) {
        Button downloadBtn = withButton(Button.class, "Download", this::downloadInvoke);

//        String webdavOpenCaptionBtn = String.format("open (v%d)", latestVersion.getNaturalVersionIdentifier());
        Button webdavOpenBtn = withButton(Button.class, "Open", this::webdavOpenInvoke);

        HBoxLayout hBox = componentsFactory.createComponent(HBoxLayout.class);
        hBox.add(downloadBtn);
        hBox.add(webdavOpenBtn);
        return hBox;
    }

    protected void webdavOpenInvoke(Action.ActionPerformedEvent actionPerformedEvent) {
        WebdavDocumentVersion tracked = webdavDocumentVersionsDs.getItem();

        String url = urlManagementService.retrieveConcreteVersionUrlByWebdavDocumentVersion(tracked);

        Page.getCurrent().open(url, "_top");
    }

    protected void downloadInvoke(Action.ActionPerformedEvent actionPerformedEvent) {
        WebdavDocumentVersion tracked = webdavDocumentVersionsDs.getItem();

        exportDisplay.show(tracked.getFileDescriptor());
    }

    protected Button withButton(Class<Button> buttonClass,
                                String name, Consumer<Action.ActionPerformedEvent> handler) {

        Button component = componentsFactory.createComponent(buttonClass);
        component.setAction(new BaseAction(name).withHandler(handler));
        return component;
    }

}