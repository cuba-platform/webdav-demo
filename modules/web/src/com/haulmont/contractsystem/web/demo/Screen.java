package com.haulmont.contractsystem.web.demo;

import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.AbstractAction;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.DataGrid;
import com.haulmont.webdav.entity.WebdavDocumentVersion;

import javax.inject.Inject;
import java.util.Map;

public class Screen extends AbstractWindow {

    @Inject
    protected Metadata metadata;
    @Inject
    protected DataGrid<WebdavDocumentVersion> data;

    @Override
    public void init(Map<String, Object> params) {



        super.init(params);
        data.setItemClickAction(new AbstractAction("itemClickAction") {
            @Override
            public void actionPerform(Component component) {
                WebdavDocumentVersion customer = data.getSingleSelected();

                if (customer != null) {
                    showNotification("Item clicked for: " + customer.getInstanceName(), NotificationType.HUMANIZED);
                    customer.getMetaClass().getProperties();
                }
            }
        });

        data.setEnterPressAction(new AbstractAction("enterPressAction") {
            @Override
            public void actionPerform(Component component) {
                WebdavDocumentVersion customer = data.getSingleSelected();
                if (customer != null)
                    showNotification("Enter pressed for: " + customer.getInstanceName(), NotificationType.HUMANIZED);
            }
        });
    }
}