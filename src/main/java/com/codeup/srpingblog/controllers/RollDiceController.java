package com.codeup.srpingblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
class RollDiceController {

    @RequestMapping(path = "/roll-dice", method = RequestMethod.GET)
    public String guess(){
        return "roll-dice";
    }

    @RequestMapping(path = "/roll-dice/{n}", method = RequestMethod.GET)
    public String numGuessed(@PathVariable int n, Model model){
        List<Integer> diceRolls = new ArrayList<>();

        Random rand = new Random();
        int randRoll = rand.nextInt(6)+1;
        int randRoll2 = rand.nextInt(6)+1;
        int randRoll3 = rand.nextInt(6)+1;
        int randRoll4 = rand.nextInt(6)+1;
        int userRoll = n;
        int matched = 0;

        diceRolls.add(randRoll);
        diceRolls.add(randRoll2);
        diceRolls.add(randRoll3);
        diceRolls.add(randRoll4);

        model.addAttribute("randRoll", randRoll);
        model.addAttribute("randRoll2", randRoll2);
        model.addAttribute("randRoll3", randRoll3);
        model.addAttribute("randRoll4", randRoll4);

        model.addAttribute("diceRolls", diceRolls);
        model.addAttribute("userRoll", userRoll);
        model.addAttribute("matched", matched);

        return "roll-dice";
    }
}
