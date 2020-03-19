package com.codeup.srpingblog.models;


import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 140)
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Post(){
        //DEFAULT CONSTRUCTOR
    }

    //CONSTRUCTOR
    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    //GETTERS

    public long getId() {
        return id;
    }
    public String getTitle() {
        return this.title;
    }
    public String getBody() {
        return this.body;
    }

    //SETTERS

    public void setId(long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setBody(String body) {
        this.body = body;
    }
}
