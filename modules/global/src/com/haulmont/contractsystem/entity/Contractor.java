package com.haulmont.contractsystem.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import org.hibernate.validator.constraints.Email;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@NamePattern("%s|name")
@Table(name = "CONTRACTSYSTEM_CONTRACTOR")
@Entity(name = "contractsystem$Contractor")
public class Contractor extends StandardEntity {
    private static final long serialVersionUID = -1175858030817571086L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Email
    @Column(name = "EMAIL", nullable = false, unique = true)
    protected String email;


    @OneToOne(fetch = FetchType.LAZY, mappedBy = "contractor")
    protected Contract contract;

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Contract getContract() {
        return contract;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


}