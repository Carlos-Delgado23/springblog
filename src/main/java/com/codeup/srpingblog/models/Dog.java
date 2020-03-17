//package com.codeup.srpingblog.models;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="dogs")
//public class Dog {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column (columnDefinition = "TINYINT(3) UNSIGNED", nullable = false, length = 2)
//    private int age;
//
//    @Column(nullable = false, length = 100)
//    private String name;
//
//    @Column(nullable = false, columnDefinition = "CHAR(2) DEFAULT 'XX'")
//    private String resideState;
//
//
//    public Dog() {}
//
//    //GETTERS AND SETTERS
//    public long getId() {
//        return this.id;
//    }
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public int getAge() {
//        return this.age;
//    }
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getName() {
//        return this.name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getResideState() {
//        return this.resideState;
//    }
//    public void setResideState(String resideState) {
//        this.resideState = resideState;
//    }
//}
