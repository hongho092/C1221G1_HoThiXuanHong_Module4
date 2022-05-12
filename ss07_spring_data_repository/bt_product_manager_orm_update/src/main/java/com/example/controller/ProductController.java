package com.example.controller;

import com.example.model.Category;
import com.example.model.Product;
import com.example.service.ICategoryService;
import com.example.service.IProductService;
import jdk.nashorn.internal.runtime.options.Option;
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
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

//    @GetMapping(value = "")
//    public String goList(@PageableDefault(value = 3) Pageable pageable, Model model,
//                         @RequestParam Optional<String> search_name,
//                         @RequestParam Optional<String> search_detail) {
//        String searchName = search_name.orElse("");
//        String searchDetail = search_detail.orElse("");
//        Page<Product> productList = productService.findAll1(searchName, searchDetail, pageable);
//        model.addAttribute("productList", productList);
//        model.addAttribute("categoryList", categoryService.findAll());
//        return "list";
//    }


    @GetMapping(value = "")
    public String goList(@PageableDefault(value = 6) Pageable pageable, Model model,
                         @RequestParam Optional<String> search_name,
                         @RequestParam Optional<String> search_detail,
                         @RequestParam Optional<Integer> search_category){
        String searchName = search_name.orElse("");
        String searchDetail = search_detail.orElse("");
        int search_categoryVal = search_category.orElse(-1);
        Page<Product> productList = null;
        if (search_categoryVal == -1) {
            productList = productService.findAll1(searchName, searchDetail, pageable);
        } else {
            productList = productService.findAll2(searchName, searchDetail, search_categoryVal, pageable);
        }
        model.addAttribute("productList", productList);
        model.addAttribute("categoryList", categoryService.findAll());
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreate(Model model) {
        model.addAttribute("product", new Product());
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "create";
    }

    @PostMapping(value = "/save")
    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("mess", "Create Success");
        return "redirect:/";
    }

    @GetMapping(value = "/detail")
    public String detailProduct(@RequestParam int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "detail";
    }

    @GetMapping(value = "/delete")
    public String deleteProduct(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Product product = productService.findById(id);
        productService.remove(product);
        redirectAttributes.addFlashAttribute("mess", "Delete Success");
        return "redirect:/";
    }

    @GetMapping(value = "/edit")
    public String goEdit(@RequestParam int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "edit";
    }

    @PostMapping(value = "/save_edit")
    public String editProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.edit(product);
        redirectAttributes.addFlashAttribute("mess", "Edit Success");
        return "redirect:/";
    }
}
