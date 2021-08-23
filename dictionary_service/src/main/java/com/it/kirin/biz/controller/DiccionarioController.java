package com.it.kirin.biz.controller;


import com.it.kirin.biz.service.IDiccionarioService;
import com.it.tools.core.base.AbstractController;
import com.it.tools.core.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jiangwei
 * @since 2021-08-18
 */
@RestController
@RequestMapping("/diccionario")
public class DiccionarioController extends AbstractController {
    @Autowired
    private IDiccionarioService iDiccionarioService;

    @GetMapping("/getDicName")
    public String getDicNameByCode(String type,String code){
        return iDiccionarioService.getDicnameByCode(type, code);
    }

}

