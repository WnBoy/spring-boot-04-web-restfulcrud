package com.xupt.springboot.config;

import com.xupt.springboot.filter.Myfilter;
import com.xupt.springboot.linster.MyLinster;
import com.xupt.springboot.servelt.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author Wnlife
 * @create 2020-04-24 10:10
 *
 * 专门注册服务器的类
 *
 * 练习注册三大组件
 */
@Configuration
public class MyserverConfig {

    /**
     * 注册servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean<MyServlet> myServletServletRegistrationBean =
                new ServletRegistrationBean<>(new MyServlet(), "/myServlet");
        return myServletServletRegistrationBean;
    }

    /**
     * 注册Filter
     * @return
     */
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new Myfilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return filterRegistrationBean;
    }

    /**
     * 注册Listener
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean myLinster(){
        ServletListenerRegistrationBean servletListenerRegistrationBean =
                new ServletListenerRegistrationBean(new MyLinster());
        return servletListenerRegistrationBean;
    }

}
