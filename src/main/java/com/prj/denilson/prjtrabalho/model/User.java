package com.prj.denilson.prjtrabalho.model;

import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(unique = true)
    private String phone; //TODO: não usar tipo primitivo
    @Column(nullable = false)
    private String name;
    @Column(updatable = false, nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private UserType type;

    @Enumerated(EnumType.ORDINAL)
    private UserStatus status = UserStatus.ATIVO;

    public User(){
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
        hidePassword();
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public UserType getType() {
        return type;
    }

    public void hidePassword() {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
