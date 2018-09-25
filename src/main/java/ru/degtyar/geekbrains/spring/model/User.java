package ru.degtyar.geekbrains.spring.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Data
@Setter
@Entity

public class User {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(unique = true, nullable = false)
    private String login;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String password;

    @Column
    private Boolean disabled;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Authority> authorities = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Role> role = new ArrayList<>();

    public User(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public User(String login, String email, String password){
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public List<Role> getRoles() {
        return role;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getEmail() {
        return email;
    }
}
