package com.xupt.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Wnlife
 * @create 2020-04-22 13:28
 */
@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(String username, String password,
                        Map<String,Object>map,
                        HttpSession session){
        if(!StringUtils.isEmpty(username)&&"123".equals(password)){
            //登录成功，将用户信息放置到session中
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            map.put("msg","密码错误");
            //登录失败
            return "login";
        }
    }

}
