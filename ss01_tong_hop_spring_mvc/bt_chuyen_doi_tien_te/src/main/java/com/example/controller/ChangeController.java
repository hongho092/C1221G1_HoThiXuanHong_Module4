package com.example.controller;

import com.example.service.ChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeController {

    @Autowired
    private ChangeService changeService;

    @GetMapping (value = "")
    public String goInput () {
        return "input_dollar";
    }

    @PostMapping (value = "/change")
    public String change (@RequestParam Integer dollar, Model model) {
        int vnd = changeService.changeVND(dollar);
        model.addAttribute("vnd", vnd);
        model.addAttribute("dollar", dollar);
        return "input_dollar";
    }
}
