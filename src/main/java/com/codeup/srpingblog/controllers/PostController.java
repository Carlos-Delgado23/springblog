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
    public String getPosts(Model model){
        List<Post> postList = new ArrayList<>();

        postList.add(new Post(2, "Title 2", "Body 2"));
        postList.add(new Post(3, "Title 3", "Body 3"));

        model.addAttribute("posts", postList); //pass list
        return "posts/index";
    }


    @RequestMapping (path = "/posts/{id}", method = RequestMethod.GET)
    public String getPost(@PathVariable int id, Model model){
        Post post1 = new Post(id, "first post", "remote learning");
        model.addAttribute("title", post1.getTitle());
        model.addAttribute("body", post1.getBody());
        return "posts/show";
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
