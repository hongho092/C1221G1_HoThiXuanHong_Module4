package com.hongho.controller;

import com.hongho.service.IMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    @Autowired
    private IMainService mainService;

//    @GetMapping(value = "")
//    public String list(Model model,
//                       @PageableDefault(value = 3) Pageable pageable,
//                       @RequestParam Optional<String> search_name,
//                       @RequestParam Optional<Integer> search_category){
//        List<LoaiGiaoDich> loaiGiaoDichList = loaiGiaoDichService.findAll();
//        String searchName = search_name.orElse("");
//        int searchCategory = search_category.orElse(-1);
//        Page<GiaoDich> giaoDichPage = null;
//        if (searchCategory == -1) {
//            giaoDichPage = giaoDichService.findAll1(searchName, pageable);
//        } else {
//            giaoDichPage = giaoDichService.findAll2(searchName, searchCategory, pageable);
//        }
//        model.addAttribute("searchName", searchName);
//        model.addAttribute("searchCategory", searchCategory);
//        model.addAttribute("giaoDichPage", giaoDichPage);
//        model.addAttribute("loaiGiaoDichList", loaiGiaoDichList);
//        return "list";
//    }
//
//    @GetMapping(value = "/detail")
//    public String detailGiaoDich(@RequestParam int id, Model model) {
//        GiaoDich giaoDich = giaoDichService.findById(id);
//        model.addAttribute("giaoDich", giaoDich);
//        return "detail";
//    }
//
//    @GetMapping(value = "/create")
//    public String goCreate(Model model) {
//        model.addAttribute("giaoDichDto", new GiaoDichDto());
//        List<LoaiGiaoDich> loaiGiaoDichList = loaiGiaoDichService.findAll();
//        List<KhachHang> khachHangList = khachHangService.findAll();
//        model.addAttribute("loaiGiaoDichList", loaiGiaoDichList);
//        model.addAttribute("khachHangList", khachHangList);
//        return "create";
//    }
//
//    @PostMapping(value = "/save")
//    public String createGiaoDich(@ModelAttribute @Validated GiaoDichDto giaoDichDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
////        List<Product> productList = productService.findAll();
////        new GiaoDichDto().validate1(productDto, bindingResult, productList);
//        new GiaoDichDto().validate(giaoDichDto, bindingResult);
//        if(bindingResult.hasFieldErrors()) {
//            List<LoaiGiaoDich> loaiGiaoDichList = loaiGiaoDichService.findAll();
//            List<KhachHang> khachHangList = khachHangService.findAll();
//            model.addAttribute("loaiGiaoDichList", loaiGiaoDichList);
//            model.addAttribute("khachHangList", khachHangList);
//            return "create";
//        } else {
//            GiaoDich giaoDich = new GiaoDich();
//            BeanUtils.copyProperties(giaoDichDto, giaoDich);
//            giaoDichService.save(giaoDich);
//            redirectAttributes.addFlashAttribute("mess", "Create Success");
//            return "redirect:/";
//        }
//    }
//
//    @GetMapping(value = "/delete")
//    public String deleteGiaoDich(@RequestParam int id, RedirectAttributes redirectAttributes) {
//        GiaoDich giaoDich = giaoDichService.findById(id);
//        giaoDichService.delete(giaoDich);
//        redirectAttributes.addFlashAttribute("mess", "Delete Success");
//        return "redirect:/";
//    }
}
