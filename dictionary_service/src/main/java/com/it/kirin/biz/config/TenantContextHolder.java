package com.it.kirin.biz.config;

import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import org.springframework.stereotype.Component;

@Component
public class TenantContextHolder implements TenantHandler {
    private static final String TENANT_ID_COLUMN = "tenant_id";
    public Expression getTenantId(boolean select) {
        return new StringValue(String.valueOf(MyTenantHandler.getTenantId()));
    }

    public String getTenantIdColumn() {
        return TENANT_ID_COLUMN;
    }

    public boolean doTableFilter(String tableName) {
        return false;
    }
}
