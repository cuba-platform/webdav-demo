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
@Table(name = "CONTRACTSYSTEM_ENTITY_WITH_MANY_TO_MANY_FILE_DESCRIPTOR")
@Entity(name = "contractsystem$EntityWithManyToManyFileDescriptor")
public class EntityWithManyToManyFileDescriptor extends StandardEntity {
    private static final long serialVersionUID = -1823040609249245410L;

    @Column(name = "NAME")
    protected String name;

    @JoinTable(name = "CONTRACTSYSTEM_ENTITY_WITH_MANY_TO_MANY_FILE_DESCRIPTOR_FILE_DESCRIPTOR_LINK",
        joinColumns = @JoinColumn(name = "ENTITY_WITH_MANY_TO_MANY_FILE_DESCRIPTOR_ID"),
        inverseJoinColumns = @JoinColumn(name = "FILE_DESCRIPTOR_ID"))
    @ManyToMany
    protected List<FileDescriptor> fileDescriptors;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFileDescriptors(List<FileDescriptor> fileDescriptors) {
        this.fileDescriptors = fileDescriptors;
    }

    public List<FileDescriptor> getFileDescriptors() {
        return fileDescriptors;
    }


}