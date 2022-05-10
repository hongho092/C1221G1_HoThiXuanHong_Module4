package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping(value = "")
    public String goList(Model model){
        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("blogList", blogList);
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping(value = "/save")
    public String createProduct(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Create Success");
        return "redirect:/";
    }

    @GetMapping(value = "/detail")
    public String detailProduct(@RequestParam int id, Model model) {
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog", blog);
        return "detail";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Blog blog = iBlogService.findById(id);
        iBlogService.delete(blog);
        redirectAttributes.addFlashAttribute("mess", "Delete Success");
        return "redirect:/";
    }

    @GetMapping(value = "/edit")
    public String goEdit(@RequestParam int id, Model model) {
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog", blog);
        return "edit";
    }

    @PostMapping(value = "/save_edit")
    public String editProduct(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.edit(blog);
        redirectAttributes.addFlashAttribute("mess", "Edit Success");
        return "redirect:/";
    }
}
