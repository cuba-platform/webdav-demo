package com.haulmont.contractsystem.web.demo;

import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.webdav.components.WebdavDocumentLink;
import com.haulmont.webdav.entity.WebdavDocumentVersion;
import org.apache.commons.lang.StringUtils;

import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;

public class LookDemo extends AbstractWindow {

    @Inject
    protected ComponentsFactory componentsFactory;

    @Inject
    protected CollectionDatasource<WebdavDocumentVersion, UUID> webdavDocumentVersionsDs;

    protected WebdavDocumentLink selectedLink;


    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        webdavDocumentVersionsDs.addItemChangeListener(e -> {
                    WebdavDocumentVersion version = webdavDocumentVersionsDs.getItem();
                    if (version == null) {
                        selectedLink = null;
                        return;
                    }
                    selectedLink = ((WebdavDocumentLink) getComponent(version.getId().toString()));
                }
        );
    }

    public Component generateActionsCell(WebdavDocumentVersion entity) {
        return returnTestData(entity);
    }

    Component returnTestData(WebdavDocumentVersion entity) {
        WebdavDocumentLink link = componentsFactory.createComponent(WebdavDocumentLink.class)
                .withFileDescriptor(entity.getFileDescriptor());
        link.setId(entity.getId().toString());
        registerComponent(link);

        /*switch (n++) {
            case 1:
                link.setIsShowVersion(false);
                break;
            case 2:
                link.setCaption("thisIsCustomCaption");
                break;
            case 3:
                link.setIsShowVersion(false);
                link.setIcon("icons/save.png");
                break;
            case 4:
                link.setCaption("");
                link.setIcon("icons/download.png");
                break;
        }*/

        return link;
    }

    public void showVersion() {
        if (selectedLink == null) {
            return;
        }
        selectedLink.setIsShowVersion(! selectedLink.getIsShowVersion());
    }

    public void onSetCubaDownloadIconClick() {
        if (selectedLink == null) {
            return;
        }

        selectedLink.setIcon(StringUtils.isBlank(selectedLink.getIcon()) ? "icons/download.png" : "");
    }

    public void onSetVaadinFontWordIconClick() {
        if (selectedLink == null) {
            return;
        }

        selectedLink.setIcon(StringUtils.isBlank(selectedLink.getIcon()) ? "font-icon:FILE_WORD_O" : "");
    }

    public void onRemoveCaptionClick() {
        if (selectedLink == null) {
            return;
        }

        selectedLink.setCaption("");
    }
}