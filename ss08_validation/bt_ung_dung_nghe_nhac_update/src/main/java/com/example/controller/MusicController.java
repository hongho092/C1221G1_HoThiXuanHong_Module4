package com.example.controller;

import com.example.dto.MusicDto;
import com.example.model.Music;
import com.example.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MusicController {

    @Autowired
    private IMusicService iMusicService;

    @GetMapping(value = "")
    public String goList(Model model) {
        List<Music> musicList = iMusicService.findAll();
        model.addAttribute("musicList", musicList);
        return "list";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "create";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute @Validated MusicDto musicDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto, music);
            iMusicService.save(music);
            redirectAttributes.addFlashAttribute("mess", "Create Success");
            return "redirect:/";
        }
    }

    @GetMapping(value = "/detail")
    public String detail(@RequestParam int id, Model model) {
        Music music = iMusicService.findOne(id);
        model.addAttribute("music", music);
        return "detail";
    }

    @GetMapping(value = "/edit")
    public String edit(@RequestParam int id, Model model) {
        Music music = iMusicService.findOne(id);
        model.addAttribute("music", music);
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String save_edit(@ModelAttribute Music music, RedirectAttributes redirectAttributes) {
        iMusicService.update(music);
        redirectAttributes.addFlashAttribute("mess", "Edit Success");
        return "redirect:/";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Music music = iMusicService.findOne(id);
        iMusicService.delete(music);
        redirectAttributes.addFlashAttribute("mess", "Delete Success");
        return "redirect:/";
    }

}
