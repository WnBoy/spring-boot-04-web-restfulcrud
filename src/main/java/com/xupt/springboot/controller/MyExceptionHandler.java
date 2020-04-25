package com.xupt.springboot.controller;

import com.xupt.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wnlife
 * @create 2020-04-23 19:45
 */
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 缺点：无论什么客户端，返回的都是json数据，没有自适应的效果
     */
   /* @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String, Object> handlerException(Exception e){
        Map<String, Object> map=new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return map;
    }*/

    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request){
        Map<String, Object> map=new HashMap<>();
        map.put("code","user.notexist");
        map.put("message","错误了oo");
//Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        request.setAttribute("javax.servlet.error.status_code",500);

        request.setAttribute("exc",map);
        return "forward:/error";
    }

}
