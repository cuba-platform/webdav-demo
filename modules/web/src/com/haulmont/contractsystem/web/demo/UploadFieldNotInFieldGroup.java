package com.haulmont.contractsystem.web.demo;

import com.haulmont.cuba.gui.components.AbstractWindow;

public class UploadFieldNotInFieldGroup extends AbstractWindow {

    public void onSaveClick() {
        getDsContext().commit();
    }
}