package com.vti.entity;

public class Student {
    private static int count = 0;
    private int id;
    private String name;

    public Student(String name)
    {
        count++;
        this.id = count;
        this.name = name;
    }
    /**
     * @deprecated replaced by {@link this.getid()}
     */
    @Deprecated
    public int getId(){
        return this.id;
    }


    public String getid()
    {
        return "MSV : " + id;
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
}
