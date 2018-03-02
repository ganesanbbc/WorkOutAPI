package com.cts.userinfo.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("password")
    @Expose
    private String password;

    public UserInfo(String userId, String password) {

        this.userId = userId;
        this.password = password;
    }


    public UserInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
