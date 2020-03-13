package com.codeup.srpingblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class MathController {

    @GetMapping("/{math}/{num1}/{by}/{num2}")
    @ResponseBody
    public String math(@PathVariable String math, @PathVariable int num1, @PathVariable String by,
                     @PathVariable int num2){
        if (math.equals("add") && by.equals("and")){
            return String.format("%d + %d = %d", num1, num2, (num1 + num2));

        } else if (math.equals("subtract") && by.equals("from")) {
            return String.format("%d - %d = %d", num1, num2, (num1 - num2));

        } else if (math.equals("multiply") && by.equals("and")){
            return String.format("%d * %d = %d", num1, num2, (num1 * num2));

        } else if (math.equals("divide") && by.equals("by")){
            return String.format("%d / %d = %d", num1, num2, (num1 / num2));

        } else {
            return "Path not found";
        }
    }
}
