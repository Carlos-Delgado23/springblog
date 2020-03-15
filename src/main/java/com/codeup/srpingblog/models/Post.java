package com.codeup.srpingblog.models;

public class Post {
    private String title;
    private String body;


//    public Post(){
//        //DEFAULT CONSTRUCTOR
//    }

    //CONSTRUCTOR
    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    //GETTERS
    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }

    //SETTERS
    public void setTitle(String title) {
        this.title = title;
    }
    public void setBody(String body) {
        this.body = body;
    }
}
