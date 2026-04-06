package org.example.thymeleaf.controller;
import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.example.thymeleaf.model.UserForm;

@Controller
public class FormController {

    @GetMapping("/register")
    public String userRegistraionPage(Model m){
        UserForm uf=new UserForm();
        m.addAttribute("userform", uf);
        List<String> listprofession=Arrays.asList("Developer","Tester","Architect");
        m.addAttribute("listprofession", listprofession);
        return "register-form";
    }

    @PostMapping("/register/save")
    public String submitForm(Model m,@ModelAttribute("userform") UserForm uf){
        m.addAttribute("userform", uf);
        return "register-sucess";
    }
}