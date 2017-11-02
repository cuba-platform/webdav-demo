package com.haulmont.contractsystem.web.contract;

import com.haulmont.bali.util.ParamsMap;
import com.haulmont.contractsystem.entity.Contract;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.HBoxLayout;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.data.GroupDatasource;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.webdav.components.DocumentLink;
import com.haulmont.webdav.dto.WebdavUrl;
import com.haulmont.webdav.entity.WebdavDocument;
import com.haulmont.webdav.entity.WebdavDocumentVersion;
import com.haulmont.webdav.service.WebdavDocumentVersionsManagementService;
import com.haulmont.webdav.service.WebdavDocumentsManagementService;
import com.haulmont.webdav.service.WebdavUrlManagementService;
import com.vaadin.server.Page;

import javax.inject.Inject;
import java.util.UUID;
import java.util.function.Consumer;

import static java.lang.String.format;

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

    @Inject
    protected GroupTable<Contract> contractsTable;

    int i = 0;

    public Component generateLinkCell(Contract entity) {


//        WebdavDocumentVersion latestVersion = documentVersionsService.retrieveLastVersionByFileDescriptorNN(
//                entity.getDocument(), "webdavDocumentVersion-with-deps-view");
//        String downloadCaptionBtn = String.format("download (v%d)", latestVersion.getNaturalVersionIdentifier());
        //Button downloadBtn = withButton(Button.class, "Download", this::downloadInvoke);
        DocumentLink documentLink = componentsFactory.createComponent(DocumentLink.class);
        //LookupField f;
        //f.ge
        //documentLink.setDocumentId(entity.getDocument().getId().toString());
        documentLink.setFileDescriptor(entity.getDocument());

        //documentLink.setDocumentCaption("newCap");
        //documentLink.setIcon("icons/save.png");

//        String webdavOpenCaptionBtn = String.format("open (v%d)", latestVersion.getNaturalVersionIdentifier());

        //DocumentLink webdavOpenBtn = withLink(DocumentLink.class, "Open", this::webdavOpenInvoke);
        //documentLink.setDocumentId(entity.getDocument().getId().toString());
        /*if (i == 0) {
            documentLink.setCaption("customCaption");
            documentLink.setEnabled(false);
        } else if (i == 1) {
            documentLink.setIsShowVersion(false);
        } else if (i == 2) {
            documentLink.setIcon("icons/save.png");
        } else if (i == 3) {
            documentLink.setIsShowVersion(false);
            documentLink.setIcon("icons/save.png");

        }
        i++;

        if (i == contractsTable.getDatasource().size()) {
            i = 0;
        }*/

        Button versionsBtnOriginal = withButton(Button.class, "Show versions", this::showVersionsInvoke);
        //DocumentLink versionsBtn = withLink(DocumentLink.class, "Show versions", this::showVersionsInvoke);

        //Button webdavOpenBtn = withButton(Button.class, "Open", this::webdavOpenInvoke);

        HBoxLayout hBox = componentsFactory.createComponent(HBoxLayout.class);
        hBox.add(documentLink);
        //documentLink.setAlignment(Alignment.MIDDLE_CENTER);
        //hBox.add(versionsBtnOriginal);
        //hBox.add(webdavOpenBtnW);
        //hBox.add(versionsBtn);
        return hBox;
    }

    protected void showVersionsInvoke(Action.ActionPerformedEvent actionPerformedEvent) {
        //showMessage(actionPerformedEvent);
        WebdavDocument document = documentsService
                .retrieveDocumentByFileDescriptorIdNN(contractsDs.getItem().getDocument().getId());

        openWindow("webdav$WebdavDocumentVersionDialog.browse", WindowManager.OpenType.DIALOG,
                ParamsMap.of("document", document));
    }

    protected void webdavOpenInvoke(Action.ActionPerformedEvent actionPerformedEvent) {
        //showMessage(actionPerformedEvent);
        Contract trackedContract = contractsDs.getItem();

        WebdavUrl url = urlManagementService.retrieveDocumentUrlByFileDescriptor(trackedContract.getDocument());

        Page.getCurrent().open(url.getUrl(), "_top");
    }

    protected void downloadInvoke(Action.ActionPerformedEvent actionPerformedEvent) {
        //showMessage(actionPerformedEvent);
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

    protected DocumentLink withLink(Class<DocumentLink> documentLinkClass,
                                    String name, Consumer<Action.ActionPerformedEvent> handler) {

        DocumentLink component = componentsFactory.createComponent(documentLinkClass);
        //component.setAction(new BaseAction(name).withHandler(handler));
        return component;
    }

    public Component generateLatestVersionCell(Contract entity) {
        WebdavDocumentVersion latestVersion = documentVersionsService.retrieveLastVersionByFileDescriptorNN(
                entity.getDocument(), "webdavDocumentVersion-with-deps-view");

        return new Table.PlainTextCell(String.valueOf(latestVersion.getNaturalVersionId()));
    }

    private void showMessage(Action.ActionPerformedEvent actionPerformedEvent) {
        DocumentLink documentLink = (DocumentLink) actionPerformedEvent.getComponent();
        showNotification(format("documentId=%s", documentLink.getDocumentId()));
    }
}