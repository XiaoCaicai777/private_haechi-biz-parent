package com.it.kirin.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.it.kirin.biz.enums.LogicDel;
import com.it.kirin.biz.model.Diccionario;
import com.it.kirin.biz.mapper.DiccionarioMapper;
import com.it.kirin.biz.service.IDiccionarioService;
import com.it.tools.core.base.BaseServiceImpl;
import org.apache.ibatis.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jiangwei
 * @since 2021-08-18
 */
@Service
public class DiccionarioServiceImpl extends BaseServiceImpl<DiccionarioMapper, Diccionario> implements IDiccionarioService {
    @Cacheable(value={"DicName"})
    public String getDicnameByCode(String type, String code) {
        Diccionario diccionario = baseMapper.selectOne(
                new LambdaQueryWrapper<Diccionario>(new Diccionario().setDicCode(code).setDicTypeCode(type).setLogicDel(LogicDel.NO.getCode()))
        );
        if(diccionario!=null){
            return diccionario.getDicName();
        }
        return null;
    }
}
