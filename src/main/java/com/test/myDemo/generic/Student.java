package com.test.myDemo.generic;

/**
 * @author liangliang.gu
 * @date 2021/3/4
 */
public class Student extends People{

    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
