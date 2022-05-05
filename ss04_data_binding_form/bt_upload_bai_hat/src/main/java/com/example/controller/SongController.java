package com.example.controller;

import com.example.model.Song;
import com.example.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping(value = "")
    public String listSong(Model model){
        List<Song> songs = songService.getAllSong();
        model.addAttribute("song", songs);
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreate(Model model){
        model.addAttribute("song", new Song());
        model.addAttribute("kom", new String[] {"pop", "rock", "classic", "r&b", "jazz", "hiphop"});
        return "create";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute Song song, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "Success");
        songService.save(song);
        return "redirect:/";
    }
}
