package com.haulmont.contractsystem.web.demo;

import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.Security;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.security.entity.EntityOp;
import com.haulmont.webdav.entity.WebdavDocument;
import com.haulmont.webdav.entity.WebdavDocumentVersion;

import javax.inject.Inject;
import java.util.Map;

public class SecurityDemoWindow extends AbstractWindow {

    @Inject
    protected Security security;

    @Inject
    protected Label statusLabel;

    @Inject
    protected Metadata metadata;

    @Inject
    protected Button applyButton;

    @Inject
    protected LookupField documentLookup;
    @Inject
    protected LookupField versionLookup;

    protected String redColor = "<font color=red>";
    protected String greenColor = "<font color=lightGreen>";

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        StringBuilder statusText = new StringBuilder("STATUS:");

        for (Class clazz : new Class[]{WebdavDocument.class, WebdavDocumentVersion.class}) {
            for (EntityOp op : new EntityOp[]{EntityOp.READ, EntityOp.UPDATE, EntityOp.CREATE, EntityOp.DELETE}) {
                addStatus(statusText, clazz, op);
            }
        }

        statusLabel.setValue(statusText.toString());
    }

    protected void addStatus(StringBuilder statusText, Class clazz, EntityOp entityOp) {
        boolean canRead = security.isEntityOpPermitted(metadata.getClass(clazz), entityOp);

        statusText.append("<br>")
                .append(canRead ? greenColor : redColor)
                .append(metadata.getClass(clazz))
                .append("=")
                .append(entityOp)
                .append("</font>");
    }

    public void apply() {
        WebdavDocument document = documentLookup.getValue();
        WebdavDocumentVersion version = versionLookup.getValue();

        if (document == null || version == null) {
            showNotification("Select document and version");
            return;
        }

        if (document.getVersions().contains(version)) {
            showNotification("Already added");
            return;
        }

        version.setWebdavDocument(document);
        getDsContext().getDataSupplier().commit(version);

        getDsContext().refresh();
    }

    public void addVersion() {
        WebdavDocument document = documentLookup.getValue();
        WebdavDocumentVersion version = versionLookup.getValue();

        if (document == null || version == null) {
            showNotification("Select document and version");
            return;
        }

        if (document.getVersions().contains(version)) {
            showNotification("Already added");
            return;
        }

        document.getVersions().add(version);
        getDsContext().getDataSupplier().commit(document);

        getDsContext().refresh();
    }
}