package com.haulmont.contractsystem.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.webdav.annotation.WebdavSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NamePattern("%s|name")
@Table(name = "CONTRACTSYSTEM_CONTRACT_WITH_DISABLED_WEBDAV")
@Entity(name = "contractsystem$ContractWithDisabledWebdav")
public class ContractWithDisabledWebdav extends StandardEntity {
    private static final long serialVersionUID = 9119066911475670079L;

    @Column(name = "NAME")
    protected String name;

    @WebdavSupport(enabled = false)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE_ID")
    protected FileDescriptor file;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFile(FileDescriptor file) {
        this.file = file;
    }

    public FileDescriptor getFile() {
        return file;
    }


}