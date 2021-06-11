package com.vti.entiy;

public class Student1 implements IStudent{
    private int id;
    private String name;
    private int group;


    public Student1(int id , String name , int group ){
        this.id = id;
        this.name = name;
        this.group = group;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void diemDanh() {
        System.out.println(this.name + " điểm danh");
    }

    @Override
    public void hocBai() {
        System.out.println(this.name + " học bài");
    }

    @Override
    public void donVeSinh() {
        System.out.println(this.name + " dọn vệ sinh");
    }
}
