package com.NoviBackend.Autogarage.models;

public class User {
    private Long id;
    private String username;
    private String password;
    private String employeeRole;


    public User(Long id, String username, String password, String employeeRole) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.employeeRole = employeeRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", employeeRole='" + employeeRole + '\'' +
                '}';
    }
}
