package com.it.biz.config.mybatis;

import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import org.springframework.stereotype.Component;


@Component
public class MyTenantHandler implements TenantHandler {
    private final String TENANT_ID = "tenant_id";
    @Override
    public Expression getTenantId(boolean select) {
        return new StringValue(TenantContextHolder.getTenantId());
    }

    @Override
    public String getTenantIdColumn() {
        return TENANT_ID;
    }

    @Override
    public boolean doTableFilter(String tableName) {
        return false;
    }
}
