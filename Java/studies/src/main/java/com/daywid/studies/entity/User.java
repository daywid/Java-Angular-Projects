package com.daywid.studies.entity;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class User {
    //Especifica a chave primaria da entidade.
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) //Gera um auto increment na tabela do banco de dados.
    private Long id;
    private String name;
    private String email;

    public User(){}

    public User(String name, String email){
        super();
        this.name = name;
        this.email = email;
    }

    @ManyToMany //relacionamento de 1 pra muitos.
    private Set<Role> roles; 

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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
