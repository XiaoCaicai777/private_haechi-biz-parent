package com.it.kirin.biz.service;

import com.it.kirin.biz.model.Diccionario;
import com.it.tools.core.base.IBaseService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jiangwei
 * @since 2021-08-18
 */
public interface IDiccionarioService extends IBaseService<Diccionario> {
        String getDicnameByCode(String type,String code);
}
