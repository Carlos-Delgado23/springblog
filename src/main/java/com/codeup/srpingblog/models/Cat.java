package com.codeup.srpingblog.models;

import javax.persistence.*;

@Entity
@Table(name = "cats")
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column (columnDefinition = "TINYINT(3) UNSIGNED", nullable = false, length = 2)
    public int age;

    @Column(nullable = false, length = 100)
    public String name;

    @Column(name = "reside_state", nullable = false, columnDefinition = "CHAR(2) DEFAULT 'XX'")
    public String resideState;

    public Cat() {}


    // GETTERS AND SETTERS
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getResideState() { return resideState; }
    public void setResideState(String resideState) { this.resideState = resideState; }
}
