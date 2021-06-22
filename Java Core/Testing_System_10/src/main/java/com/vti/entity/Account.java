package com.vti.entity;

public class Account {
    private int id;
    private String name;
    private  Department department;

    public Account(int id, String name, Department department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\n'  +
                "department name :  "  +  department.getName() +
                '}';
    }
}
