package com.example.controller;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = "")
    public String goList(@PageableDefault(value = 3, sort = {}) Pageable pageable, Model model, @RequestParam Optional<String> search){
        String searchVal = search.orElse("");
        Page<Blog> blogList = iBlogService.findAll(searchVal, pageable);
        System.out.println(blogList);
        model.addAttribute("searchVal", searchVal);
        model.addAttribute("blogList", blogList);
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreate(Model model) {
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
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
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
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
