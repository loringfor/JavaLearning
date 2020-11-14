package com.loring.jdk8_new;

public class Test {
    public static void main(String[] args) {
        People people = new People(1,"Loring",22,110);

    }
}

class People{
    private int id;
    private String name;
    private int age;
    private int phone;

    public static void sayHello(){
        System.out.println("My name is ");
    }

    public People(int id, String name, int age, int phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }
    public People(){}

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
