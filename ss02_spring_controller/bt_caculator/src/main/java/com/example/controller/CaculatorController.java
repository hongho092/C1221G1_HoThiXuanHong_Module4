package com.example.controller;

import com.example.service.CaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public String goMenu() {
//        return "menu";
//    }

    @Autowired
    private CaculatorService caculatorService;

    @GetMapping(value = "")
    public String goCaculator() {
        return "menu";
    }

    @GetMapping(value = "/calculator")
    public String addition(@RequestParam int number1, @RequestParam int number2, @RequestParam String calculator,Model model) {
        int result = caculatorService.getResult(number1, number2, calculator);
        model.addAttribute("show", "Result is");
        model.addAttribute("result", result);
        return "menu";
    }

}
