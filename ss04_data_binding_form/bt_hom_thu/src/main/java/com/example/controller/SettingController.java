package com.example.controller;

import com.example.model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SettingController {

    @GetMapping(value = "")
    public String goSetting(Model model) {
        model.addAttribute("setting", new Setting());
        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("pageSizes", new int[]{ 5, 10, 15, 25, 50, 100});
        return "infoSetting";
    }

    @PostMapping(value = "/save")
    public String showSetting(@ModelAttribute Setting setting, Model model) {
        model.addAttribute("setting", setting);
        return "showSetting";
    }

}
