package com.haulmont.contractsystem.web.webdavdocumentversion;

import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.data.GroupDatasource;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.webdav.components.DocumentVersionLink;
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
        Button webdavOpenBtn = withButton(Button.class, "Open read-only", this::webdavOpenInvoke);
        DocumentVersionLink versionLink = componentsFactory.createComponent(DocumentVersionLink.class);
        versionLink.setAlignment(Alignment.BOTTOM_CENTER);

        HBoxLayout hBox = componentsFactory.createComponent(HBoxLayout.class);
        hBox.add(downloadBtn);
        hBox.add(versionLink);
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