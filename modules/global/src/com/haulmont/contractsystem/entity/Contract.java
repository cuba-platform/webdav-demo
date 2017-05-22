package com.haulmont.contractsystem.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.webdav.entity.WebdavFileDescriptor;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Table(name = "CONTRACTSYSTEM_CONTRACT")
@Entity(name = "contractsystem$Contract")
public class Contract extends StandardEntity {
    private static final long serialVersionUID = -1834442845605423406L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @JoinTable(name = "CONTRACTSYSTEM_CONTRACT_WEBDAV_FILE_DESCRIPTOR_LINK",
        joinColumns = @JoinColumn(name = "CONTRACT_ID"),
        inverseJoinColumns = @JoinColumn(name = "WEBDAV_FILE_DESCRIPTOR_ID"))
    @OnDelete(DeletePolicy.CASCADE)
    @ManyToMany
    protected List<WebdavFileDescriptor> documents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTRACTOR_ID")
    protected Contractor contractor;

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public Contractor getContractor() {
        return contractor;
    }


    public void setDocuments(List<WebdavFileDescriptor> documents) {
        this.documents = documents;
    }

    public List<WebdavFileDescriptor> getDocuments() {
        return documents;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}