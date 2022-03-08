package com.haimp03.onfashion.controllers.backend;

import com.haimp03.onfashion.dto.UserData;
import com.haimp03.onfashion.entity.User;
import com.haimp03.onfashion.rest_api.RestWeather;
import com.haimp03.onfashion.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestWeather restWeather;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public String index(Model model){
        model.addAttribute("weatherData", restWeather.getCurrentWeather());
        return "backend/pages/user/index";
    }

    @GetMapping("/create")
    public String addUser(Model model){
        model.addAttribute("weatherData", restWeather.getCurrentWeather());
        model.addAttribute("userData", new UserData());
        return "backend/pages/user/create";
    }

    @PostMapping("/store")
    public String store(@Valid UserData userData, BindingResult bindingResult,RedirectAttributes redirectAttributes, Model model) {
        try {
            if (bindingResult.hasErrors()) {
                model.addAttribute("weatherData", restWeather.getCurrentWeather());
                return "backend/pages/user/create";
            } else {
                userData.setUser_id(userData.user_id);
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String encodedPassword = passwordEncoder.encode(userData.password);
                userData.setPassword(encodedPassword);
                userService.addUser(modelMapper.map(userData, User.class));
            }
            redirectAttributes.addFlashAttribute("successMessage","Successfully Add New Data");
        } catch (Exception ex) {
            if (ex.getCause().getMessage().equalsIgnoreCase("could not execute statement")) {
                redirectAttributes.addFlashAttribute("errorMessage", "Username already available");
            }      
          }
        return "redirect:/admin/user";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("weatherData", restWeather.getCurrentWeather());
        model.addAttribute("userData", modelMapper.map(userService.findById(id).get(), UserData.class));
        return "backend/pages/user/edit";
    }

    @PostMapping("/update")
    public String update(@Valid UserData userData, BindingResult bindingResult, RedirectAttributes redirectAttributes,
    Model model) {
        try {
            if (bindingResult.hasErrors()) {
                model.addAttribute("weatherData", restWeather.getCurrentWeather());
                return "backend/pages/user/edit";
            } else {
                if(userData.password == ""){
                    userData.setUser_id(userData.user_id);
                    userService.updateUserWithoutPassword(modelMapper.map(userData, User.class));
                } else {
                    userData.setUser_id(userData.user_id);
                    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                    String encodedPassword = passwordEncoder.encode(userData.password);
                    userData.setPassword(encodedPassword);
                    userService.updateUser(modelMapper.map(userData, User.class));
                }
            }
            redirectAttributes.addFlashAttribute("successMessage","Successfully Update Data");
        } catch (Exception ex) {
            if (ex.getCause().getMessage().equalsIgnoreCase("could not execute statement")) {
                redirectAttributes.addFlashAttribute("errorMessage", "Username already exist");
            }   
        }
        return "redirect:/admin/user";
    }

    @GetMapping("/{id}/delete")
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
		userService.deleteUser(id);
        redirectAttributes.addFlashAttribute("successMessage","Successfully Deleted Data");
        return "redirect:/admin/user";
	}
    
}