package com.xupt.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author Wnlife
 * @create 2020-04-23 21:12
 * 给容器中加入我们自己定义的ErrorAttributes
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        //异常处理器里面的数据
        Map<String,Object> exc = (Map<String, Object>) webRequest.getAttribute("exc", 0);
        //将其放置到map中
        map.put("exc",exc);
        //自定义的数据
        map.put("company","xupt");
        return map;
    }
}
