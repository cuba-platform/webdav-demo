package com.haulmont.contractsystem.entity;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.webdav.annotation.WebdavSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "CONTRACTSYSTEM_CONTRACT")
@Entity(name = "contractsystem$Contract")
public class Contract extends StandardEntity {
    private static final long serialVersionUID = - 1834442845605423406L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @NotNull
    @WebdavSupport
    @OnDelete(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DOCUMENT_ID")
    protected FileDescriptor document;

    @OnDelete(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTRACTOR_ID")
    protected Contractor contractor;

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public Contractor getContractor() {
        return contractor;
    }


    public void setDocument(FileDescriptor document) {
        this.document = document;
    }

    public FileDescriptor getDocument() {
        return document;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}