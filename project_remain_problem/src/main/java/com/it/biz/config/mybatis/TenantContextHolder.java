package com.it.biz.config.mybatis;

import cn.hutool.core.thread.ThreadUtil;


public class TenantContextHolder {
    private static final ThreadLocal<String> THREAD_LOCAL_TENANT = ThreadUtil.createThreadLocal(true);

    public static void setTenantId(String tenantId){
        THREAD_LOCAL_TENANT.remove();
        THREAD_LOCAL_TENANT.set(tenantId);
    }

    public static String getTenantId(){
        return THREAD_LOCAL_TENANT.get();
    }

    public static void remove(){
        THREAD_LOCAL_TENANT.remove();
    }
}
