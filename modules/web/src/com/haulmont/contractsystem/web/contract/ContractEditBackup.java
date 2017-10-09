package com.haulmont.contractsystem.web.contract;

import com.haulmont.contractsystem.entity.Contract;
import com.haulmont.cuba.core.global.Configuration;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.FileMultiUploadField;
import com.haulmont.cuba.gui.data.impl.DatasourceImplementation;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;

import javax.inject.Inject;
import java.util.Map;

public class ContractEditBackup extends AbstractEditor<Contract> {

    @Inject
    protected FileMultiUploadField multiUploadField;

    @Inject
    protected FileUploadingAPI fileUploadingAPI;

    @Inject
    protected Metadata metadata;

    @Inject
    protected ExportDisplay exportDisplay;

    @Inject
    protected Configuration configuration;

    @Inject
    protected DatasourceImplementation<Contract> contractDs;

    @Inject
//    protected CollectionDatasource<WebdavFileDescriptor, UUID> documentsDs;
//
//    @Inject
//    protected Table<WebdavFileDescriptor> documentsTable;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
//
//        multiUploadField.addQueueUploadCompleteListener(this::multiUploadCompleteListener);
//        multiUploadField.addFileUploadErrorListener(event ->
//                showNotification("File upload error", NotificationType.HUMANIZED));
//
//        documentsTable.setItemClickAction(documentsTable.getAction("open"));
    }

//    protected void multiUploadCompleteListener() {
//        Contract contract = contractDs.getItem();
//
//        for (Map.Entry<UUID, String> upload : multiUploadField.getUploadsMap().entrySet()) {
//            FileDescriptor fDesc = fileUploadingAPI.getFileDescriptor(upload.getKey(), upload.getValue());
//
//            // silent continue if file have not been found in tmp directory
//            if (fDesc == null) continue;
//
//            WebdavFileDescriptor webdavFileDescriptor = createWebdavFileDescriptorByFileDescriptor(fDesc, fileUploadingAPI.getFile(upload.getKey()));
//            documentsDs.addItem(webdavFileDescriptor);
//            //contractDocuments.add(webdavFileDescriptor);
//
//            try {
//                fileUploadingAPI.putFileIntoStorage(upload.getKey(), webdavFileDescriptor);
//            } catch (FileStorageException e) {
//                throw new RuntimeException("Unable to put files into storage", e);
//            }
//        }
//        documentsDs.commit();
//
//        contract.setDocuments(new ArrayList<>(documentsDs.getItems()));
//
//        contractDs.modified(contract); // because when collection of WebdavFileDescriptor is modified, contractDs hasn't state as changed
//        multiUploadField.clearUploads();
//    }
//
//    protected WebdavFileDescriptor createWebdavFileDescriptorByFileDescriptor(FileDescriptor fDesc, File tmpFile) {
//        if (tmpFile == null)
//            throw new WebdavInternalServerErrorException(WebdavCause.UPLOADED_FILE_NOT_FOUND_IN_TEMP_DIR);
//
//        WebdavFileDescriptor webdavFileDescriptor = metadata.create(WebdavFileDescriptor.class);
//        metadata.getTools().copy(fDesc, webdavFileDescriptor);
//
//        webdavFileDescriptor.setContentLength(tmpFile.length());
//        webdavFileDescriptor.setContentType(getMIMEType(webdavFileDescriptor.getName()));
//
//        return webdavFileDescriptor;
//    }
//
//    @SuppressWarnings("unused")
//    public void onOpen(Component source) {
//        WebdavFileDescriptor selected = documentsTable.getSingleSelected();
//
//        // silent exit if fileDescriptor not selected on screen
//        if (selected == null) return;
//
//        if (isSupportedByWebdav(selected)) {
//            openAsWebdavFile(selected);
//        } else {
//            downloadFile(selected);
//        }
//    }
//
//    protected boolean isSupportedByWebdav(WebdavFileDescriptor fileDescriptor) {
//        WebdavConfig webdavConfig = configuration.getConfig(WebdavConfig.class);
//        Application applicationByExtension = webdavConfig.getApplications().getApplicationByExtension(fileDescriptor.getExtension());
//
//        return applicationByExtension != null;
//    }
//
//    protected void openAsWebdavFile(WebdavFileDescriptor fileDescriptor) {
//        WebdavFileDescriptorTools webdavFileDescriptorTools = AppBeans.get(WebdavFileDescriptorTools.class);
//
//        URI url = webdavFileDescriptorTools.retrieveUriByWebdavFileDescriptor(fileDescriptor);
//
//        Page.getCurrent().open(String.valueOf(url), "_top");
//    }
//
//    protected void downloadFile(WebdavFileDescriptor fileDescriptor) {
//        exportDisplay.show(fileDescriptor);
//    }
}