package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping(value = "")
    public String greeting() {
        return "index";
    }

    @GetMapping(value = "greeting")
    public String greeting1(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "index_name";
    }

}
