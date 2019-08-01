package com.czxy.interceptor;

import com.czxy.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class myInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        User loginU = (User) request.getSession().getAttribute("loginU");
        if (url.contains("/login") || url.contains("/register") || url.contains("/css") || url.contains("/fonts") || url.contains("/js") || url.contains("/assets") || url.contains("/images") || url.contains("/jqvmap")) {
            return true;
        } else {
            if (loginU == null) {
                response.sendRedirect("login.html");
                return false;
            }
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
