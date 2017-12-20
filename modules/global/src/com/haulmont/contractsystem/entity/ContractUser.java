package com.haulmont.contractsystem.entity;

import com.haulmont.cuba.core.entity.annotation.Extends;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.webdav.entity.WebdavCredentials;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Extends(User.class)
@Entity(name = "contractsystem$ContractUser")
public class ContractUser extends User {
    private static final long serialVersionUID = 3199627093188083975L;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    protected WebdavCredentials webdavCredentials;
}