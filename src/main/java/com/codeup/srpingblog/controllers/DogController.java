package com.codeup.srpingblog.controllers;

import com.codeup.srpingblog.models.Dog;
import com.codeup.srpingblog.repositories.DogRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DogController {

    private DogRepo dogDao; // goes to DogRepo which uses the JpaRepository for crud functionality

    public DogController(DogRepo dogDao){ //Constructor dependency injection (like a getter and setter)
        this.dogDao = dogDao;
    }

    @GetMapping("/dogs")
    public String getAllDogs(Model model) {
        List<Dog> dogs = dogDao.findAll();
        model.addAttribute("dogs", dogs);
        return "dogs/index";
    }

    @GetMapping("/dogs/save")
    public String saveDog(){
        Dog newDog = new Dog();
        newDog.setAge(4);
        newDog.setName("jimmy");
        newDog.setResideState("TX");
        dogDao.save(newDog); // using the dogDao/DogRepo for the JpaRepository Crud Functionality
        return "dogs/save";
    }

    @RequestMapping(params = "/dogs/update", method = RequestMethod.GET)
    @ResponseBody
    public String updateDog(){
        Dog dog = dogDao.getOne(1L);
        dog.setName("Bruce");
        dogDao.save(dog);
        return "Updating dog";
    }

    @RequestMapping(params = "/dogs/delete", method = RequestMethod.GET)
    @ResponseBody
    public String deleteDog(){
        Dog dog = dogDao.getOne(2L);
        dogDao.delete(dog);
        return dog.getName() + " has been deleted";
    }
}
