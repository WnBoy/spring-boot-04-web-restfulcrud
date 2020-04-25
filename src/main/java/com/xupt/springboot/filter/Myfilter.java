package com.xupt.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Wnlife
 * @create 2020-04-24 10:20
 *
 * 自定义的过滤器
 */
public class Myfilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("myFilter运行了");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}
