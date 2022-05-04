package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Sandwich {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String goMenu() {
        return "menu";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam("condiment") String[] condiment, Model model) {
        model.addAttribute("mess", "Your sandwich:");
        model.addAttribute("con", condiment);
        return "menu";
    }
}
