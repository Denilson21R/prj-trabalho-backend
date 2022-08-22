package com.prj.denilson.prjtrabalho.model;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company {
    @Id
    private int id;
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user_create;
    private String email;
    private String company_name;

    public Company() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getId() {
        return id;
    }

    public User getUser_create() {
        return user_create;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getCnpj() {
        return cnpj;
    }

    private String cnpj; //TODO: não usar tipo primitivo

    public Company(User user_create, String email, String company_name, String cnpj) {
        this.user_create = user_create;
        this.email = email;
        this.company_name = company_name;
        this.cnpj = cnpj;

        //TODO: quando o usuário criar a empresa, ele recebe uma permissao
    }

    public Company(User user_create, String email, String company_name) {
        this.user_create = user_create;
        this.email = email;
        this.company_name = company_name;
    }

    public void setId(int id) {
        this.id = id;
    }
}