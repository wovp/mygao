package com.gao.mygao.controller;

import com.gao.mygao.mapper.UserMapper;
import com.gao.mygao.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

/**
 * ClassName: loginController
 * Package: com.gao.mygao.controller
 * Description:
 * Author: my
 * Creat: 2023/4/16 20:06
 * @author 11
 */
@Controller
public class loginController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public String toLoginPage(){
        return "login";
    }

    @RequestMapping("/registration")
    public String toRegistrationPage(){
        return "registration";
    }

    @RequestMapping("/home")
    public String toHomePage(){
        return "home";
    }

    @RequestMapping("/doLogin")
    public String login(
            @RequestParam(value = "username",required = false) String username,
            @RequestParam(value = "password",required = false) String password,
            @RequestParam("verifyCode") String verifyCode,
            Model model, HttpServletRequest request
    ){
        String kaptchaCode = request.getSession().getAttribute("verifyCode") + "";

        System.out.println(kaptchaCode);

        if(!verifyCode.equals(kaptchaCode)){
            model.addAttribute("verifyMsg","验证码错误");
            return "login";
        }

        String queryPassword;
        queryPassword = userMapper.getPasswordByUser(username);
        if(password.equals(queryPassword)) {
            request.getSession().setAttribute("user", username);
            return "home";
        }
        else{
             model.addAttribute("msg","账号密码错误");
             return "login";
        }
    }

    @GetMapping("/logout")
    public String UserLogOut(Model model , HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "login";
    }

    @RequestMapping("/doRegister")
    public String doRegister(Model model,
                             @RequestParam String user,
                             @RequestParam String password
                            ){

        String onlyUser = userMapper.findOnlyUser(user);
        if(onlyUser != null){
            model.addAttribute("repeaterror", "repeaterror");
            return "registration";
        }
        User user1 = new User(user, password);
        int i = userMapper.addUser(user1);
        if(i == 1) {
            return "login";
        }
        else{
            model.addAttribute("unkownerror", "error");
        }
        return "registration";
    }

}
