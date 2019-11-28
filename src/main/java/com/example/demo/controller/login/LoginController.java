package com.example.demo.controller.login;

import com.example.demo.dao.user.UserDao;
import com.example.demo.entitys.user.User;
import com.example.demo.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String showForm(LoginForm loginform) {
        return "/login/login";
    }

    @PostMapping("/login")
    public String checkForm(@Valid LoginForm loginform, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/login/login";
        }
        Example<User> example = Example.of(loginform.buildUserByUsername());
        Optional<User> userOptional = userDao.findOne(example);
        if (userOptional.isPresent()) {
            User userResult = userOptional.get();
            // 校验密码是否相等，这里还没做安全处理，仅供演示
            System.out.println("dbs userpassword: " + userResult.getPassword());
        } else {
            // 不存在该用户，设置错误信息并返回登录页面
            System.out.println("不存在用户");
            model.addAttribute("errmsg", "登录失败：用户名或密码错误");
            return "/login/login";
        }

        return "/login/login_success";
    }

}
