package com.nhnent.springmvc.interceptor;

import com.nhnent.springmvc.exception.UnAuthorizedException;
import com.nhnent.springmvc.model.Member;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        Member loginInfo = (Member) session.getAttribute("member");
        if (loginInfo == null) {
            throw new UnAuthorizedException();
        }

        return super.preHandle(request, response, handler);
    }

}
