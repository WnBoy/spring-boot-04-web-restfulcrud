package com.xupt.springboot.controller;

import com.xupt.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Wnlife
 * @create 2020-04-21 16:57
 */
@Controller
public class HelloController {

    /**
     * 跳转到templates下的index页面
     * @return
     */
//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(String user){
        if("aaa".equals(user)){
            throw new UserNotExistException();
        }
        return "Hello Controller";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object>map){

        map.put("hello","<h1>你好</h1>");
        map.put("users",Arrays.asList("zhangsan","lisi","wangwu"));
//        classpath:/templates/success.html
        return "success";
    }

}
