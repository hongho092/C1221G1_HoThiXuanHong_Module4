package com.example.controller;

import com.example.util.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@RequestMapping(value = "/login")
public class MainController {

//    private String getName(Principal principal) {
//        String name = principal.getName();
//        return name;
//    }
    private String name;

    private void get (Principal principal) {
        if (principal != null) {
            name = principal.getName();
        }
    }

//    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
//    public String welcomePage(Model model) {
//        model.addAttribute("title", "Welcome");
//        model.addAttribute("message", "This is welcome page!");
//        return "welcomePage";
//    }

//    @RequestMapping(value = "/admin", method = RequestMethod.GET)
//    public String adminPage(Model model, Principal principal) {
//
//        // thành phần đại diện cho thiết bị đang đăng nhập hiện tại
//        // org.springframework.security.core.userdetails.User [Username=dbadmin1, Password=[PROTECTED],
//        // Enabled=true, AccountNonExpired=true, credentialsNonExpired=true, AccountNonLocked=true,
//        // Granted Authorities=[ROLE_ADMIN, ROLE_USER]]
//
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//        System.out.println(loginedUser);
//
//        System.out.println("chuẩn bị lấy");
//        String userInfo = WebUtils.toString(loginedUser);
//
//        model.addAttribute("userInfo", userInfo);
//
//        return "adminPage";
//    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "login/login_page";
//        return "login/loginPage";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model, Principal principal) {

        String name1 = name;
        System.out.println("bdsahdcusad "+name1);
        model.addAttribute("name", name1);

        model.addAttribute("title", "Logout");
        return "login/logoutSuccessfulPage";
    }

//    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
//    public String userInfo(Model model, Principal principal) {
//
//        // Sau khi user login thanh cong se co principal
//        String userName = principal.getName();
//
//        System.out.println("User Name: " + userName);
//
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//        String userInfo = WebUtils.toString(loginedUser);
//
//        model.addAttribute("userInfo", userInfo);
//
//        return "userInfoPage";
//    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
            System.out.println("ta đã lấy đuwocj"+ principal.getName());

        }
        get(principal);

        return "login/403Page";
    }

}


/*
WebUtils làm việc với controller để lấy thông tin của (user) và (role của user) thông qua principal(đối tượng đã đăng nhập) được truyền vào
 */
