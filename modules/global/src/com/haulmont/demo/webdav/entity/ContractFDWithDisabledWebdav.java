package com.haulmont.demo.webdav.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.webdav.annotation.WebdavSupport;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamePattern("%s|number")
@Table(name = "WEBDAV_DEMO_CONTRACT_FD_WITH_DISABLED_WEBDAV")
@Entity(name = "webdavdemo$ContractFDWithDisabledWebdav")
public class ContractFDWithDisabledWebdav extends StandardEntity {
    private static final long serialVersionUID = 5462482399569113855L;

    @NotNull
    @Column(name = "NUMBER_", nullable = false, unique = true)
    protected String number;

    @NotNull
    @Lookup(type = LookupType.DROPDOWN)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CONTRACTOR_ID")
    protected ContractUser contractor;

    @NotNull
    @WebdavSupport(enabled = false)
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DOCUMENT_ID")
    protected FileDescriptor document;

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setContractor(ContractUser contractor) {
        this.contractor = contractor;
    }

    public ContractUser getContractor() {
        return contractor;
    }

    public void setDocument(FileDescriptor document) {
        this.document = document;
    }

    public FileDescriptor getDocument() {
        return document;
    }
}