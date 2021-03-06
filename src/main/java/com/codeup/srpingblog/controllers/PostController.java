package com.codeup.srpingblog.controllers;


import com.codeup.srpingblog.models.Post;
import com.codeup.srpingblog.models.User;
import com.codeup.srpingblog.repositories.PostRepo;
import com.codeup.srpingblog.repositories.UserRepo;
import com.codeup.srpingblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
class PostController {

    private UserRepo userDao;
    private PostRepo postDao;

    private EmailService emailService;

    public PostController(PostRepo postDao, UserRepo userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }


    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String viewPosts(Model model){
        model.addAttribute("posts", postDao.findAll());
        model.addAttribute("users", userDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable(name = "id") Long id, Model model){
        Post post = postDao.getOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping ("/posts/create")
    public String createForm(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Post post = new Post();
        post.setUser(user);
        model.addAttribute("post", post);
        emailService.prepareAndSend(post, post.getTitle(), post.getBody());
        return "posts/create";
    }

    // save button
    @PostMapping(value = "/saveButton")
    public String savePost(@ModelAttribute("post") Post post){
        emailService.prepareAndSend(post, "This is the subject", "Hey welcome to our team");
        postDao.save(post);
        return "redirect:/posts";
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

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable(name = "id") Long id){
        postDao.deleteById(id);
        return "redirect:/posts";
    }
}
