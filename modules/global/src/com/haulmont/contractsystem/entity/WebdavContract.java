package com.haulmont.contractsystem.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.webdav.entity.WebdavDocument;

@NamePattern("%s|name")
@Table(name = "CONTRACTSYSTEM_WEBDAV_CONTRACT")
@Entity(name = "contractsystem$WebdavContract")
public class WebdavContract extends StandardEntity {
    private static final long serialVersionUID = -532344524147189638L;

    @Column(name = "NAME")
    protected String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTRACTOR_ID")
    protected Contractor contractor;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_ID")
    protected WebdavDocument document;

    public void setDocument(WebdavDocument document) {
        this.document = document;
    }

    public WebdavDocument getDocument() {
        return document;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public Contractor getContractor() {
        return contractor;
    }


}