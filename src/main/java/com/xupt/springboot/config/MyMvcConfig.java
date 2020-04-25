package com.xupt.springboot.config;

import com.xupt.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Wnlife
 * @create 2020-04-21 20:25
 * 使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
 */
//@EnableWebMvc   不要接管SpringMVC
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        //浏览器访问/xupt,返回success.html页面
        registry.addViewController("/xupt").setViewName("success");
    }

    /**
     * 扩展的springmvc的功能
     *
     * @return
     */
    @Bean//将自定义的扩展的springmvc的功能
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            //注册自己添加的视图解析器
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册自己定义的拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new MyLoginInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/","/index.html","/user/login");
            }
        };
        return adapter;
    }

    /**
     * 将自定义的LocaleResolver添加到容器中
     *
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
