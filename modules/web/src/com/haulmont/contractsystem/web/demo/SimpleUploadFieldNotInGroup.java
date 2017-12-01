package com.haulmont.contractsystem.web.demo;

import com.haulmont.contractsystem.entity.ContractWithSimpleFileDescriptor;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.FileUploadField;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import java.util.UUID;

public class SimpleUploadFieldNotInGroup extends AbstractWindow {

    @Inject
    protected CollectionDatasource<ContractWithSimpleFileDescriptor, UUID> contractWithSimpleFileDescriptorsDs;

    @Inject
    protected Label selectedItem;

    @Inject
    protected FileUploadField contractsUpload;

    @Override
    public void ready() {
        contractWithSimpleFileDescriptorsDs.addItemChangeListener(e -> selectedItem.setValue("Selected: " + e.getItem()));
    }

    public void onSaveClick() {
        if (! validateAll()) {
            return;
        }
        getDsContext().commit();
    }
}