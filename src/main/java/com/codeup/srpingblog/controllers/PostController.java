package com.codeup.srpingblog.controllers;


import com.codeup.srpingblog.models.Post;
import com.codeup.srpingblog.repositories.PostRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
class PostController {

    private PostRepo postDao;

    public PostController(PostRepo postDao) {
        this.postDao = postDao;
    }

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String viewPosts(Model model){
        List<Post> posts = postDao.findAll();

//        postList.add(new Post(2, "Title 2", "Body 2"));
//        postList.add(new Post(3, "Title 3", "Body 3"));
        model.addAttribute("posts", posts); //pass list
        return "posts/index";
    }


    @RequestMapping (path = "/posts/{id}", method = RequestMethod.GET)
    public String viewPost(@PathVariable int id, Model model){
        Post post = postDao.findById(id);
//        Post post1 = new Post(id, "first post", "remote learning");
//        model.addAttribute("title", post1.getTitle());
//        model.addAttribute("body", post1.getBody());
        model.addAttribute("post", post);
        return "posts/show";
    }

    @RequestMapping (path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String createForm(){
            Post post = new Post();
            post.setId(43);
            post.setTitle("NEW post");
            post.setBody("body to NEW post");

            postDao.save(post);
            return "post created";
    }

//    @PostMapping ("/posts/create")
//    @ResponseBody
//    public String postNewPost(){
//        Post post = new Post();
//        post.setId(43);
//        post.setTitle("NEW post");
//        post.setBody("body to NEW post");
//
//        postDao.save(post);
//        return "post created";
//    }


    @GetMapping("/posts/edit")
    @ResponseBody
    public String editPost(String title){
        Post post = postDao.getOne(2L);

        post.setTitle("new updated title");
        post.setBody("couple edits to body");

        postDao.save(post);

        return "edited the post";
    }

    @GetMapping("/posts/delete")
    @ResponseBody
    public String deletePost(String title){

        Post post = postDao.getOne(3L);
        postDao.delete(post);

        return "deleted the post";
    }
}
