package com.test.cart.Interceptor;

import com.test.cart.util.HttpUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        for (Cookie ck:cookies){
            //已经登录
            if (ck.getName().equals("isLogin")){
                //判断redis中是否该token对应的账号
                String had = HttpUtil.getJSON("http://localhost:8085/hadToken/" + ck.getValue());
                if (had.equals("1")){
                    return true;
                }
            }
        }
        response.sendRedirect("http://localhost:8085/toLogin?returnUrl:http://localhost:8082/cart/lookcart");
       return false;
    }
}
