package com.auto.time.Model;

import javax.persistence.*;

/**
 * Created by Romachka on 20.04.16.
 */
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userRole")
    private String userRole;

    @Column(name = "userLogin")
    private String userLogin;

    @Column(name = "userPassword")
    private String userPassword;

    public User() { }

    public User(String userName, String userRole, String userLogin, String userPassword) {
        this.userName = userName;
        this.userRole = userRole;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
