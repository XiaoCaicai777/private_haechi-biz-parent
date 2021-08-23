package com.it.biz.controller;


import com.it.biz.service.IHcProjectRemainProblemService;
import com.it.tools.core.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.it.tools.core.base.AbstractController;

/**
 * <p>
 * 项目遗留问题表 前端控制器
 * </p>
 *
 * @author jiangwei
 * @since 2021-08-19
 */
@RestController
@RequestMapping("/hc-project-remain-problem")
public class HcProjectRemainProblemController extends AbstractController {
    private final String PAGE_NOW = "1";
    private final String PAGE_SIZE = "10";

    @Autowired
    private IHcProjectRemainProblemService hcProjectRemainProblemService;

    @GetMapping("/test")
    public R<?> getProjectProblemList(@RequestParam(required = false,defaultValue = PAGE_NOW)Integer pageNow,@RequestParam(required = false,defaultValue = PAGE_SIZE)Integer pageSize, @RequestParam(required = false) String name){
        return R.ok(hcProjectRemainProblemService.getProjectProblemList(name, pageNow, pageSize));
    }
}

