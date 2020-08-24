package com.lizxing.aop.demo.config.interceptor;

import com.lizxing.aop.demo.annotation.LoginRequired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SourceAccessInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器");

        // 反射方式获取注解
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        LoginRequired loginRequired = handlerMethod.getMethod().getAnnotation(LoginRequired.class);

        if (loginRequired == null){
            return true;
        } else {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().println("访问此资源需要登录");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
