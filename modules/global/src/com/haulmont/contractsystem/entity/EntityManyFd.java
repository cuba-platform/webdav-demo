package com.haulmont.contractsystem.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.FileDescriptor;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@Table(name = "CONTRACTSYSTEM_ENTITY_MANY_FD")
@Entity(name = "contractsystem$EntityManyFd")
public class EntityManyFd extends StandardEntity {
    private static final long serialVersionUID = -1823040609249245410L;

    @Column(name = "NAME")
    protected String name;


    @JoinTable(name = "CONTRACTSYSTEM_MANY",
        joinColumns = @JoinColumn(name = "ENTITY_MANY_ID"),
        inverseJoinColumns = @JoinColumn(name = "FILE_DESCRIPTOR_ID"))
    @ManyToMany
    protected List<FileDescriptor> fds;

    public void setFds(List<FileDescriptor> fds) {
        this.fds = fds;
    }

    public List<FileDescriptor> getFds() {
        return fds;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}