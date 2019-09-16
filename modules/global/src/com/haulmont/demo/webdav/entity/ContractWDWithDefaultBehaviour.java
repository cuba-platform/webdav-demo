package com.haulmont.demo.webdav.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.webdav.entity.WebdavDocument;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamePattern("%s|number")
@Table(name = "WEBDAV_DEMO_CONTRACT_WD_WITH_DEFAULT_BEHAVIOUR")
@Entity(name = "webdavdemo$ContractWDWithDefaultBehaviour")
public class ContractWDWithDefaultBehaviour extends StandardEntity {
    private static final long serialVersionUID = -913660838943266195L;

    @NotNull
    @Column(name = "NUMBER_", nullable = false, unique = true)
    protected String number;

    @NotNull
    @Lookup(type = LookupType.DROPDOWN)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CONTRACTOR_ID")
    protected ContractUser contractor;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DOCUMENT_ID")
    protected WebdavDocument document;

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

    public void setDocument(WebdavDocument document) {
        this.document = document;
    }

    public WebdavDocument getDocument() {
        return document;
    }
}