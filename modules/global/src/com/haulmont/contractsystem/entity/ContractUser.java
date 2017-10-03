package com.haulmont.contractsystem.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import com.haulmont.cuba.core.entity.annotation.Extends;
import javax.persistence.Column;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.webdav.entity.WebdavCredentials;
import com.haulmont.webdav.entity.WebdavUserEmbedded;
import com.haulmont.webdav.entity.WebdavUserImplemented;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Extends(User.class)
@Entity(name = "contractsystem$ContractUser")
public class ContractUser extends User implements WebdavUserImplemented {
    private static final long serialVersionUID = 3199627093188083975L;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    protected WebdavCredentials webdavCredentials;

    @Override
    public WebdavCredentials getWebdavCredentials() {
        return webdavCredentials;
    }

    @Override
    public void setWebdavCredentials(WebdavCredentials webdavCredentials) {
        this.webdavCredentials = webdavCredentials;
    }
}