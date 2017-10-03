package com.haulmont.contractsystem.entity;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Table(name = "CONTRACTSYSTEM_CONTRACT")
@Entity(name = "contractsystem$Contract")
public class Contract extends StandardEntity {
    private static final long serialVersionUID = -1834442845605423406L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTRACTOR_ID")
    protected Contractor contractor;


    @JoinTable(name = "CONTRACTSYSTEM_CONTRACT_FILE_DESCRIPTOR_LINK",
        joinColumns = @JoinColumn(name = "CONTRACT_ID"),
        inverseJoinColumns = @JoinColumn(name = "FILE_DESCRIPTOR_ID"))
    @OnDelete(DeletePolicy.CASCADE)
    @ManyToMany
    protected List<FileDescriptor> documents;

    public List<FileDescriptor> getDocuments() {
        return documents;
    }

    public void setDocuments(List<FileDescriptor> documents) {
        this.documents = documents;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public Contractor getContractor() {
        return contractor;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}