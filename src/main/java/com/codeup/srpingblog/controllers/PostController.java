package com.codeup.srpingblog.controllers;


import com.codeup.srpingblog.models.Post;
import com.codeup.srpingblog.models.User;
import com.codeup.srpingblog.repositories.PostRepo;
import com.codeup.srpingblog.repositories.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
class PostController {

    private UserRepo userDao;
    private PostRepo postDao;

    public PostController(PostRepo postDao, UserRepo userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }


    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String viewPosts(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable(name = "id") Long id, Model model){
        Post post = postDao.getOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping ("/posts/create")
    public String createForm(Model model){
            Post post = new Post();
            model.addAttribute("post", post);
            return "posts/create";
    }

//    @GetMapping("/posts/show/{id}")
//    public ModelAndView showPost(@PathVariable(name = "id") Long id){
//        ModelAndView mav = new ModelAndView();
//
//        mav.
//        return "/posts/show";
//    }


    @GetMapping("/posts/edit/{id}")
    public ModelAndView editPost(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("/posts/edit");
        Post postToEdit = postDao.getOne(id);
        mav.addObject("post", postToEdit);
        return mav;
    }

    @PostMapping("/posts/edit/{id}")
    public String updatePost(@PathVariable(name = "id") Long id, @RequestParam String title, @RequestParam String body){
        Post p = postDao.getOne(id);
        p.setTitle(title);
        p.setBody(body);
        postDao.save(p);
        return "redirect:/posts";
    }

    // save button
    @PostMapping(value = "/saveButton")
    public String savePost(@ModelAttribute("post") Post post){
        User user = new User(1, "Charlie", "c23delgado@gmail.com", "password123");
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable(name = "id") Long id){
        postDao.deleteById(id);
        return "redirect:/posts";
    }
}
