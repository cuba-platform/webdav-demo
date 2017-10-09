package com.haulmont.contractsystem.web.contract;

import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.contractsystem.entity.Contract;
import com.haulmont.cuba.gui.components.HBoxLayout;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.components.Window;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.data.GroupDatasource;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.webdav.entity.WebdavDocument;
import com.haulmont.webdav.entity.WebdavDocumentVersion;
import com.haulmont.webdav.service.WebdavDocumentVersionsManagementService;
import com.haulmont.webdav.service.WebdavDocumentsManagementService;
import com.haulmont.webdav.service.WebdavUrlManagementService;
import com.vaadin.server.Page;

import javax.inject.Inject;
import java.util.UUID;
import java.util.function.Consumer;

public class ContractBrowse extends AbstractLookup {

    @Inject
    protected ComponentsFactory componentsFactory;

    @Inject
    protected GroupDatasource<Contract, UUID> contractsDs;

    @Inject
    protected ExportDisplay exportDisplay;

    @Inject
    protected WebdavUrlManagementService urlManagementService;

    @Inject
    protected WebdavDocumentVersionsManagementService documentVersionsService;

    @Inject
    protected WebdavDocumentsManagementService documentsService;

    public Component generateLinkCell(Contract entity) {


//        WebdavDocumentVersion latestVersion = documentVersionsService.retrieveLastVersionByFileDescriptorNN(
//                entity.getDocument(), "webdavDocumentVersion-with-deps-view");
//        String downloadCaptionBtn = String.format("download (v%d)", latestVersion.getNaturalVersionIdentifier());
        Button downloadBtn = withButton(Button.class, "Download", this::downloadInvoke);

//        String webdavOpenCaptionBtn = String.format("open (v%d)", latestVersion.getNaturalVersionIdentifier());
        Button webdavOpenBtn = withButton(Button.class, "Open", this::webdavOpenInvoke);
        Button versionsBtn = withButton(Button.class, "Show versions", this::showVersionsInvoke);

        HBoxLayout hBox = componentsFactory.createComponent(HBoxLayout.class);
        hBox.add(downloadBtn);
        hBox.add(webdavOpenBtn);
        hBox.add(versionsBtn);
        return hBox;
    }

    protected void showVersionsInvoke(Action.ActionPerformedEvent actionPerformedEvent) {
        WebdavDocument document = documentsService
                .retrieveDocumentByFileDescriptorIdNN(contractsDs.getItem().getDocument().getId());

        openWindow("webdav$WebdavDocumentVersionDialog.browse", WindowManager.OpenType.DIALOG,
                ParamsMap.of("document", document));
    }

    protected void webdavOpenInvoke(Action.ActionPerformedEvent actionPerformedEvent) {
        Contract trackedContract = contractsDs.getItem();

        String url = urlManagementService.retrieveDocumentUrlByFileDescriptor(trackedContract.getDocument());

        Page.getCurrent().open(url, "_top");
    }

    protected void downloadInvoke(Action.ActionPerformedEvent actionPerformedEvent) {
        WebdavDocumentVersion latestVersion = documentVersionsService.retrieveLastVersionByFileDescriptorNN(
                contractsDs.getItem().getDocument(), "webdavDocumentVersion-with-deps-view");

        exportDisplay.show(latestVersion.getFileDescriptor());
    }

    protected Button withButton(Class<Button> buttonClass,
                                String name, Consumer<Action.ActionPerformedEvent> handler) {

        Button component = componentsFactory.createComponent(buttonClass);
        component.setAction(new BaseAction(name).withHandler(handler));
        return component;
    }

    public Component generateLatestVersionCell(Contract entity) {
        WebdavDocumentVersion latestVersion = documentVersionsService.retrieveLastVersionByFileDescriptorNN(
                entity.getDocument(), "webdavDocumentVersion-with-deps-view");

        return new Table.PlainTextCell(String.valueOf(latestVersion.getNaturalVersionIdentifier()));
    }
}