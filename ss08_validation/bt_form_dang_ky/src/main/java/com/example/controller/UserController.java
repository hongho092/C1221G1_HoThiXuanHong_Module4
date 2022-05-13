package com.example.controller;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.service.IUserService;
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
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "")
    public String goList(@PageableDefault(value = 3) Pageable pageable,
                         @RequestParam Optional<String> first_name,
                         @RequestParam Optional<String> last_name,
                         Model model) {
        String firstName = first_name.orElse("");
        String lastName = last_name.orElse("");
        Page<User> userList = userService.findAll(firstName, lastName, pageable);
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("userList", userList);
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "create";
    }

    @PostMapping(value = "/save")
    public String createProduct(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userService.save(user);
            redirectAttributes.addFlashAttribute("mess", "Create Success");
            return "redirect:/";
        }
    }

}
