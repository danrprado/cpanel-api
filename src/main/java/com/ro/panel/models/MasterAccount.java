package com.ro.panel.models;


import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Entity
@Table(name = "master_accounts")
public class MasterAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Email
    private String email;
    private String name;
    private String password;
    private String remember_token;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private Integer pin_code;
    private Integer fb_points;
    private LocalDateTime fb_time;
    private Integer level;
    private Integer cash_points;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemember_token() {
        return remember_token;
    }

    public void setRemember_token(String remember_token) {
        this.remember_token = remember_token;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public Integer getPin_code() {
        return pin_code;
    }

    public void setPin_code(Integer pin_code) {
        this.pin_code = pin_code;
    }

    public Integer getFb_points() {
        return fb_points;
    }

    public void setFb_points(Integer fb_points) {
        this.fb_points = fb_points;
    }

    public LocalDateTime getFb_time() {
        return fb_time;
    }

    public void setFb_time(LocalDateTime fb_time) {
        this.fb_time = fb_time;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getCash_points() {
        return cash_points;
    }

    public void setCash_points(Integer cash_points) {
        this.cash_points = cash_points;
    }

    @Override
    public String toString() {
        return "MasterAccount{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
