package com.hohong.controller;

import com.hohong.dto.GiaoDichDto;
import com.hohong.model.GiaoDich;
import com.hohong.model.KhachHang;
import com.hohong.model.LoaiGiaoDich;
import com.hohong.service.IGiaoDichService;
import com.hohong.service.IKhachHangService;
import com.hohong.service.ILoaiGiaoDichService;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import java.util.Optional;

@Controller
public class GiaoDichController {

    @Autowired
    private ILoaiGiaoDichService loaiGiaoDichService;

    @Autowired
    private IKhachHangService khachHangService;

    @Autowired
    private IGiaoDichService giaoDichService;

    @GetMapping(value = "")
    public String list(Model model,
                       @PageableDefault(value = 3) Pageable pageable,
                       @RequestParam Optional<String> search_name,
                       @RequestParam Optional<Integer> search_category){
        List<LoaiGiaoDich> loaiGiaoDichList = loaiGiaoDichService.findAll();
        String searchName = search_name.orElse("");
        int searchCategory = search_category.orElse(-1);
        Page<GiaoDich> giaoDichPage = null;
        if (searchCategory == -1) {
            giaoDichPage = giaoDichService.findAll1(searchName, pageable);
        } else {
            giaoDichPage = giaoDichService.findAll2(searchName, searchCategory, pageable);
        }
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchCategory", searchCategory);
        model.addAttribute("giaoDichPage", giaoDichPage);
        model.addAttribute("loaiGiaoDichList", loaiGiaoDichList);
        return "list";
    }

    @GetMapping(value = "/detail")
    public String detailGiaoDich(@RequestParam int id, Model model) {
        GiaoDich giaoDich = giaoDichService.findById(id);
        model.addAttribute("giaoDich", giaoDich);
        return "detail";
    }

    @GetMapping(value = "/create")
    public String goCreate(Model model) {
        model.addAttribute("giaoDichDto", new GiaoDichDto());
        List<LoaiGiaoDich> loaiGiaoDichList = loaiGiaoDichService.findAll();
        List<KhachHang> khachHangList = khachHangService.findAll();
        model.addAttribute("loaiGiaoDichList", loaiGiaoDichList);
        model.addAttribute("khachHangList", khachHangList);
        return "create";
    }

    @PostMapping(value = "/save")
    public String createGiaoDich(@ModelAttribute @Validated GiaoDichDto giaoDichDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
//        List<Product> productList = productService.findAll();
//        new GiaoDichDto().validate1(productDto, bindingResult, productList);
        new GiaoDichDto().validate(giaoDichDto, bindingResult);
        if(bindingResult.hasFieldErrors()) {
            List<LoaiGiaoDich> loaiGiaoDichList = loaiGiaoDichService.findAll();
            List<KhachHang> khachHangList = khachHangService.findAll();
            model.addAttribute("loaiGiaoDichList", loaiGiaoDichList);
            model.addAttribute("khachHangList", khachHangList);
            return "create";
        } else {
            GiaoDich giaoDich = new GiaoDich();
            BeanUtils.copyProperties(giaoDichDto, giaoDich);
            giaoDichService.save(giaoDich);
            redirectAttributes.addFlashAttribute("mess", "Create Success");
            return "redirect:/";
        }
    }

    @GetMapping(value = "/delete")
    public String deleteGiaoDich(@RequestParam int id, RedirectAttributes redirectAttributes) {
        GiaoDich giaoDich = giaoDichService.findById(id);
        giaoDichService.delete(giaoDich);
        redirectAttributes.addFlashAttribute("mess", "Delete Success");
        return "redirect:/";
    }
}
