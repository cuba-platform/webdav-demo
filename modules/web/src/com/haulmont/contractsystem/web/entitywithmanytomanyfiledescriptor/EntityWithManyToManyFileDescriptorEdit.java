package com.haulmont.contractsystem.web.entitywithmanytomanyfiledescriptor;

import com.haulmont.contractsystem.entity.EntityWithManyToManyFileDescriptor;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.FileMultiUploadField;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.DataSupplier;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;

import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;

public class EntityWithManyToManyFileDescriptorEdit extends AbstractEditor<EntityWithManyToManyFileDescriptor> {

    @Inject
    private FileMultiUploadField multiUpload;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private DataSupplier dataSupplier;
    @Inject
    protected CollectionDatasource<FileDescriptor, UUID> fileDescriptorsDs;

    @Override
    public void init(Map<String, Object> params) {
        multiUpload.addQueueUploadCompleteListener(() -> {
            for (Map.Entry<UUID, String> entry : multiUpload.getUploadsMap().entrySet()) {
                UUID fileId = entry.getKey();
                String fileName = entry.getValue();
                FileDescriptor fd = fileUploadingAPI.getFileDescriptor(fileId, fileName);
                // save file to FileStorage
                try {
                    fileUploadingAPI.putFileIntoStorage(fileId, fd);
                } catch (FileStorageException e) {
                    new RuntimeException("Error saving file to FileStorage", e);
                }
                // save file descriptor to database
                dataSupplier.commit(fd);
                fileDescriptorsDs.includeItem(fd);
            }
            showNotification("Uploaded files: " + multiUpload.getUploadsMap().values(), NotificationType.HUMANIZED);
            multiUpload.clearUploads();
        });

        multiUpload.addFileUploadErrorListener(event ->
                showNotification("File upload error", NotificationType.HUMANIZED));
    }
}