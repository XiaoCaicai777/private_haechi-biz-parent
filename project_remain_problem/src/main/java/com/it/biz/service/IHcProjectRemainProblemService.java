package com.it.biz.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.biz.model.HcProjectRemainProblem;
import com.it.tools.core.base.IBaseService;

import java.util.Map;

/**
 * <p>
 * 项目遗留问题表 服务类
 * </p>
 *
 * @author jiangwei
 * @since 2021-08-19
 */
public interface IHcProjectRemainProblemService extends IBaseService<HcProjectRemainProblem> {
    Page<Map<String,Object>> getProjectProblemList(String name, Integer pageNow, Integer pageSize);
}
