package com.it.biz.config;


import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.it.biz.config.mybatis.TenantContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.it.biz.controller.*.*(..))")
    public void cutController(){}

    @AfterReturning(pointcut = "cutController()",returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        logger.info("返回信息 ： {}\n", JSONUtil.toJsonPrettyStr(result));
    }

    @Before(value = "cutController()")
    public void before(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        if(request == null){
            throw new RuntimeException("未能获取到request对象");
        }
        String header = request.getHeader("current-tenant-id");
        TenantContextHolder.setTenantId(header);
    }
}
