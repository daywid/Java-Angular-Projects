package com.daywid.web2.entity;

import java.util.List;

import com.daywid.web2.StatusRole;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;

    @Enumerated(EnumType.STRING)
    private StatusRole status;

    private List<Functionality> functionalities ;

    public Role(){}

    public Role(String name, StatusRole status, List<Functionality> functionalities) {
        this.name = name;
        this.status = status;
        this.functionalities = functionalities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusRole getStatus() {
        return status;
    }

    public void setStatus(StatusRole status) {
        this.status = status;
    }

    public List<Functionality> getFunctionalities() {
        return functionalities;
    }

    public void setFunctionalities(List<Functionality> functionalities) {
        this.functionalities = functionalities;
    }

}
