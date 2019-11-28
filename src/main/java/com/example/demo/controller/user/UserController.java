package com.example.demo.controller.user;

import com.example.demo.dao.UserDao;
import com.example.demo.entitys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 1) 如果只是使用 @RestController 注解Controller，则Controller中的方法无法返回jsp页面，或者html，
 * 配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return里的内容，
 * 多用于返回ajax请求要求的json等。
 *
 * 2) 如果需要返回到指定页面，则需要用 @Controller 配合视图解析器 InternalResourceViewResolver 才行。
 * 如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。
 */
//@RestController
@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    //访问/hello或者/hi任何一个地址，都会返回一样的结果
    @RequestMapping(value = {"/user"}, method = RequestMethod.GET)
    @ResponseBody
    public List<User> say() {
        return userDao.findAll();
    }

    @RequestMapping(value = {"/user/list"}, method = RequestMethod.GET)
    public String userlist(Model model) {
        List<User> userList = userDao.findAll();
        model.addAttribute("userlist", userList);
        return "/user/user_list";
    }

    // 如果需要事务的话，在service层加@Transaction注解

}
