package com.example.listitem;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Users {
    private int id;

    private String name;

    @SerializedName("username")
    private String userName;

    private String email;

    private UserAddress address;

    private String phone;

    private String website;

    private UserCompany company;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public UserAddress getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public UserCompany getCompany() {
        return company;
    }
}