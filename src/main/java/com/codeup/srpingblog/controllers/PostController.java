package com.codeup.srpingblog.controllers;


import com.codeup.srpingblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
class PostController {

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String posts(){
        List<Post> postList = new ArrayList<>();

        postList.add(new Post("Title 1", "Body 1"));
        postList.add(new Post("Title 2", "Body 2"));
        return "/posts/index";
    }


    @RequestMapping (path = "/posts/{id}", method = RequestMethod.GET)
    public String postsId(@PathVariable int id, Model model){
        Post post = new Post( );

        model.addAttribute(post);
        return "/posts/show";
    }

    @RequestMapping (path = "/posts/create", method = RequestMethod.GET)
    public String createForm(){
        return "/posts/create";
    }

    @PostMapping ("/posts/create")
    public String postNewPost(){
        return "/posts/create";
    }
}
