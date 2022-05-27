package com.hohong.controller;

import com.hohong.dto.DonHangDto;
import com.hohong.model.DonHang;
import com.hohong.service.IDonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DonHangController {

    @Autowired
    private IDonHangService donHangService;

    @GetMapping(value = "")
    public String goHome(@PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<DonHang> donHangPage = donHangService.findAll(pageable);
        model.addAttribute("donHangPage", donHangPage);
        return "list";
    }

    @PostMapping(value = "search_day")
    public String searchDay(@RequestParam String startDay,
                                        @RequestParam String endDay,
                                        @PageableDefault(value = 3) Pageable pageable,
                                        Model model) {

        Page<DonHang> donHangPageSearchDay = donHangService.findAllSearchDay(startDay, endDay, pageable);
        model.addAttribute("donHangPageSearchDay", donHangPageSearchDay);
        return "list_search_day";
    }

    @PostMapping(value = "top")
    public String listTop(@RequestParam int top,

                          Model model) {
        List<DonHangDto> donHangPageTop = donHangService.findAllByTop(top);
        model.addAttribute("donHangPageTop", donHangPageTop);
        return "list_top";
    }

}
