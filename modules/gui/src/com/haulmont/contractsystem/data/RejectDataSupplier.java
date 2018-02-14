package com.haulmont.contractsystem.data;

import com.haulmont.webdav.data.impl.WebdavDataSupplier;
import com.haulmont.webdav.entity.WebdavDocumentVersion;
import com.haulmont.webdav.merge.MergePolicy;
import com.haulmont.webdav.merge.RejectMergePolicy;

/**
 * @author zharenov
 */
public class RejectDataSupplier extends WebdavDataSupplier {

    @Override
    protected MergePolicy<WebdavDocumentVersion> getDefaultMergePolicy() {
        return new RejectMergePolicy<>();
    }
}
