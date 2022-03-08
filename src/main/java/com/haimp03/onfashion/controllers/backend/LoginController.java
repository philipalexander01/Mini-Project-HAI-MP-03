package com.haimp03.onfashion.controllers.backend;


import com.haimp03.onfashion.dto.UserData;
import com.haimp03.onfashion.entity.User;
import com.haimp03.onfashion.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("userData", new UserData());
        return "backend/pages/user/login";
    }

    @PostMapping("/login")
    public String signin(@ModelAttribute("user") User user){
        User loggedUser = userService.login(user.getUsername(), user.getPassword());

        if (Objects.nonNull(loggedUser)) {
            return "redirect:/admin/user";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logout(HttpServletRequest request, HttpServletResponse response){
        return "redirect:/login";
    }
}
