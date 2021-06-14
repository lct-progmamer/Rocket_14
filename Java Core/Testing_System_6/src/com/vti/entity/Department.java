package com.vti.entity;

public class Department {
    private int id;
    private String name;


    public Department(int id ,  String name)
    {
        this.id = id;
        this.name = name;
    }
    public void show(){
        System.out.println("Id : " + this.id);
        System.out.println("name : " + this.name);
    }




}
