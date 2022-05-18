package com.example.controller;

import com.example.dto.BlogDto;
import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.BeanUtils;
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
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "")
    public String goList(@PageableDefault(value = 3, sort = {}) Pageable pageable, Model model, @RequestParam Optional<String> search){
        String searchVal = search.orElse("");
        Page<Blog> blogList = blogService.findAll(searchVal, pageable);
        System.out.println(blogList);
        model.addAttribute("searchVal", searchVal);
        model.addAttribute("blogList", blogList);
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreate(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blogDto", new BlogDto());
        return "create";
    }

    @PostMapping(value = "/save")
    public String createProduct(@ModelAttribute BlogDto blogDto, RedirectAttributes redirectAttributes) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Create Success");
        return "redirect:/";
    }

    @GetMapping(value = "/detail")
    public String detailProduct(@RequestParam int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "detail";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Blog blog = blogService.findById(id);
        blogService.delete(blog);
        redirectAttributes.addFlashAttribute("mess", "Delete Success");
        return "redirect:/";
    }

    @GetMapping(value = "/edit")
    public String goEdit(@RequestParam int id, Model model) {
        Blog blog = blogService.findById(id);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", blog);
        return "edit";
    }

    @PostMapping(value = "/save_edit")
    public String editProduct(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.edit(blog);
        redirectAttributes.addFlashAttribute("mess", "Edit Success");
        return "redirect:/";
    }
}
