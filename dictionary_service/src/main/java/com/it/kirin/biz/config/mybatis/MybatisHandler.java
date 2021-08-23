package com.it.kirin.biz.config.mybatis;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import com.it.kirin.biz.config.MyTenantHandler;
import com.it.kirin.biz.config.TenantContextHolder;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MybatisHandler{
    @Autowired
    private TenantContextHolder tenantContextHolder;

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");
        List<ISqlParser> sqlParserList = new ArrayList<ISqlParser>();
        //攻击sql阻断解析器，加入解析连
        sqlParserList.add(new BlockAttackSqlParser());
        TenantSqlParser tenantSqlParser = new TenantSqlParser();
        //加入租户解析器
        tenantSqlParser.setTenantHandler(tenantContextHolder);
        sqlParserList.add(tenantSqlParser);
        paginationInterceptor.setSqlParserList(sqlParserList);
        return paginationInterceptor;
    }

    /**
     * 添加乐观锁： 希望更新数据时，这条记录没有别别人更新
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }
}
