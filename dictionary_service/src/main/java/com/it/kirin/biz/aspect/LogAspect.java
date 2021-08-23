package com.it.kirin.biz.aspect;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.it.kirin.biz.config.MyTenantHandler;
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

    @Pointcut("execution(* com.it.kirin.biz.controller.*.*(..))")
    static void controllerAspect(){}

    @AfterReturning(pointcut = "controllerAspect()", returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result) throws Exception  {
        if(result == null){
            return;
        }
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        if (logger != null){
            logger.debug("返回数据 -> \n{}", result);
        }
    }

    @Before("controllerAspect()")
    public void before(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        if(request == null){
            throw new RuntimeException("未能获取request对象");
        }
        MyTenantHandler.setTenantId(10001L);
    }
}
