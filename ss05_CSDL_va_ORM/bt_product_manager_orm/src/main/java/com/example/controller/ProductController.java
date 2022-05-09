package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
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
public class ProductController {

    @Autowired
    private ProductService productService;

//    private final ProductService productService;
//
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

    @GetMapping(value = "")
    public String goList(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreate(Model model) {
        model.addAttribute("product", new Product());
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
        return "edit";
    }

    @PostMapping(value = "/save_edit")
    public String editProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.edit(product.getId(), product);
        System.out.println(product.getId());
        redirectAttributes.addFlashAttribute("mess", "Edit Success");
        return "redirect:/";
    }

    @PostMapping(value = "/search")
    public String searchProduct(@RequestParam String search, Model model) {
        List<Product> productList = productService.searchByName(search);
        model.addAttribute("productList", productList);
        model.addAttribute("mess", "Searched");
        return "list";
    }
}
