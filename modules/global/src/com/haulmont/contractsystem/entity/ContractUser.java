package com.haulmont.contractsystem.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import com.haulmont.cuba.core.entity.annotation.Extends;
import javax.persistence.Column;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.webdav.entity.WebdavUserEmbedded;
import com.haulmont.webdav.entity.WebdavUserImplemented;

@Extends(User.class)
@Entity(name = "contractsystem$ContractUser")
public class ContractUser extends User implements WebdavUserImplemented {
    private static final long serialVersionUID = 3199627093188083975L;

    @Embedded
    protected WebdavUserEmbedded webdavUserEmbedded;

    public WebdavUserEmbedded getWebdavUserEmbedded() {
        return webdavUserEmbedded;
    }

    public void setWebdavUserEmbedded(WebdavUserEmbedded webdavUserEmbedded) {
        this.webdavUserEmbedded = webdavUserEmbedded;
    }
}