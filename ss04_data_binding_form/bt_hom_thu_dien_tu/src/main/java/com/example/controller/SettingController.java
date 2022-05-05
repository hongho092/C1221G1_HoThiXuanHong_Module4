package com.example.controller;

import com.example.model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingController {

    @RequestMapping (value = "")
    public ModelAndView goSetting() {
        ModelAndView modelAndView = new ModelAndView("");
//        model.addAttribute("setting", new Setting());
        return modelAndView;
    }
}
