package com.codeup.srpingblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class PostController {

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String posts(){
        return "post index page";
    }

    @RequestMapping (path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String postsId(@PathVariable int id){
        return "post the post with id of => " + id;
    }

    @RequestMapping (path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String postsCreate(){
        return "Form to create a post.";
    }

    @PostMapping ("/posts/create")
    @ResponseBody
    public String postCreateMethod(){
        return "post the method button?";
    }
}
