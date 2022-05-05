package com.example.controller;

import com.example.model.Form;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FormController {

    @GetMapping(value = "")
    public String goForm(Model model) {
        model.addAttribute("form", new Form());
        model.addAttribute("gender", new String[]{"nam", "nữ"});
        model.addAttribute("vehicle", new String[]{"Tàu bay", "Tàu thuyền", "Ô tô", "Khác(ghi rõ)"});
        return "show";
    }

    @PostMapping(value = "/save")
    public String infoForm(@ModelAttribute Form form, Model model) {
        model.addAttribute("form", form);
        return "info";
    }

    @PostMapping(value = "/edit")
    public String editForm(@ModelAttribute Form form, Model model) {
        model.addAttribute("formEdit", form);
        model.addAttribute("form", new Form());
        model.addAttribute("gender", new String[]{"nam", "nữ"});
        model.addAttribute("vehicle", new String[]{"Tàu bay", "Tàu thuyền", "Ô tô", "Khác(ghi rõ)"});
        model.addAttribute("mess", "Sửa thông tin");
        return "show";
    }
}
