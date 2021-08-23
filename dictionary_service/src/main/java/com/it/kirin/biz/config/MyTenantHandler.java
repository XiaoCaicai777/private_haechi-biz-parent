package com.it.kirin.biz.config;

import cn.hutool.core.thread.ThreadUtil;
import org.springframework.stereotype.Component;

public class MyTenantHandler {

    private static final ThreadLocal<Long> CURRENT_THREAD = ThreadUtil.createThreadLocal(true);

    public static void setTenantId(Long tenantId){
        CURRENT_THREAD.remove();
        CURRENT_THREAD.set(tenantId);
    }

    public static Long getTenantId(){
        return CURRENT_THREAD.get();
    }

    public static void remove(){
        CURRENT_THREAD.remove();
    }

}
