package com.example.controller;

import com.example.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

    @Autowired
    DictionaryService dictionaryService;

    @GetMapping (value = "")
    public String goHome () {
        return "search";
    }

    @PostMapping (value = "search")
    public String search (@RequestParam String word, Model model) {
        String newWord = dictionaryService.searchWork(word);
        model.addAttribute("newWord", newWord);
        return "search";
    }
}
