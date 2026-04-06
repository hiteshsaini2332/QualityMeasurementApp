package org.example.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller1{

    @GetMapping("/helloworld")
    public String hw(Model m){
        m.addAttribute("message", "Hello World");
        return "hello-world";
    }

}