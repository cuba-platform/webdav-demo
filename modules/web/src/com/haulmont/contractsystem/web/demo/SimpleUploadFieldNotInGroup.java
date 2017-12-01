package com.haulmont.contractsystem.web.demo;

import com.haulmont.contractsystem.entity.ContractWithSimpleFileDescriptor;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import java.util.UUID;

public class SimpleUploadFieldNotInGroup extends AbstractWindow {

    @Inject
    protected CollectionDatasource<ContractWithSimpleFileDescriptor, UUID> contractWithSimpleFileDescriptorsDs;

    @Inject
    protected Label selectedItem;



    @Override
    public void ready() {
        contractWithSimpleFileDescriptorsDs.addItemChangeListener(e -> {
            //selectedDs.setItem(e.getItem());
            selectedItem.setValue("Selected: " + e.getItem());
        });
    }

    public void onSaveClick() {
        getDsContext().commit();
    }
}