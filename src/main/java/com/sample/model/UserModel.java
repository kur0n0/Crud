package com.sample.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserModel {
    private int id;
    private String Name;
    private int Age;
    private String Surname;

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

    public String getSurname() {
        return Surname;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Age=" + Age +
                ", Surname='" + Surname + '\'' +
                '}';
    }
}
