package com.itheima.controller;

import com.itheima.model.Cust;
import com.itheima.model.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findUserLogin")
    public String login(User user, Model model, HttpSession session) {
        Boolean result = userService.login(user);
        if (result) {
            session.setAttribute("user",user);
            return "forward:/jsp/index.jsp";
        } else {
            model.addAttribute("msg","账号或密码错误");
            return "redirect:/jsp/login.jsp";
        }
    }

    @RequestMapping("/findAll")
    public List<Cust> findAll() {
        List<Cust> custList =userService.findAll();
        return custList;
    }
}
