package com.sjl.learn.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class AccessTokenInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(AccessTokenInterceptor.class.getName());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("preHandler:" + request.getRequestURI());
        String accessToken = request.getHeader("token");
        logger.info(accessToken);
        if ("123".equals(accessToken)) {
            return super.preHandle(request, response, handler);
        } else {
            return false;
        }
    }
}
