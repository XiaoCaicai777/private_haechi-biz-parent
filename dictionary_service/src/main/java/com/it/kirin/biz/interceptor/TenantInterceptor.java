package com.it.kirin.biz.interceptor;

import cn.hutool.core.util.StrUtil;
import com.it.kirin.biz.config.MyTenantHandler;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TenantInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        MyTenantHandler.remove();
        String header = request.getHeader("current-tenant-id");
        if(StrUtil.isNotEmpty(header)){
            return true;
        }
        return false;
    }
}
