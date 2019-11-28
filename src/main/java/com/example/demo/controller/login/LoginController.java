package com.example.demo.controller.login;

import com.example.demo.form.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LoginController {

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String showForm(LoginForm loginform) {
        return "/login/login";
    }

    @PostMapping("/login")
    public String checkForm(@Valid LoginForm loginform, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/login/login";
        }

        return "redirect:/login/login_success";
    }

}
