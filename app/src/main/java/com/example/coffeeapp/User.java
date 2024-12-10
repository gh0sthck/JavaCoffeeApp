package com.example.coffeeapp;

import androidx.annotation.NonNull;

public class User extends Models {
    private int id;
    private String name;
    private String phone;

    User(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    @NonNull
    @Override
    public String toString() {
        return "<User" + this.id + ": " + this.name + ", " + this.phone + ">";
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }
}
