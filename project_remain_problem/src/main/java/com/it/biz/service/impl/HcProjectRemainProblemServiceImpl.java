package com.it.biz.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.biz.enums.ControllerContext;
import com.it.biz.enums.LogicDel;
import com.it.biz.feign.DicServiceFeign;
import com.it.biz.model.HcProjectRemainProblem;
import com.it.biz.mapper.HcProjectRemainProblemMapper;
import com.it.biz.service.IHcProjectRemainProblemService;
import com.it.tools.core.base.BaseServiceImpl;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 项目遗留问题表 服务实现类
 * </p>
 *
 * @author jiangwei
 * @since 2021-08-19
 */
@Service
public class HcProjectRemainProblemServiceImpl extends BaseServiceImpl<HcProjectRemainProblemMapper, HcProjectRemainProblem> implements IHcProjectRemainProblemService {
        @Autowired
        private DicServiceFeign dicService;
        public Page<Map<String,Object>> getProjectProblemList(String name, Integer pageNow, Integer pageSize){
        if(name==null){
            name = "";
        }
        LambdaQueryWrapper<HcProjectRemainProblem> hcProjectRemainProblemLambdaQueryWrapper = new LambdaQueryWrapper<>();
        hcProjectRemainProblemLambdaQueryWrapper.like(HcProjectRemainProblem::getProblemName,name);
        hcProjectRemainProblemLambdaQueryWrapper.eq(HcProjectRemainProblem::getLogicDel, LogicDel.NO.getCode());
        Page<HcProjectRemainProblem> hcProjectRemainProblemPage = baseMapper.selectPage(new Page<HcProjectRemainProblem>(pageNow, pageSize), hcProjectRemainProblemLambdaQueryWrapper);
        List<HcProjectRemainProblem> records = hcProjectRemainProblemPage.getRecords();
        List<Map<String, Object>> collect = records.stream().map(record -> {
            Map<String, Object> stringObjectMap = BeanUtil.beanToMap(record);
            String dicName = dicService.getDicName(ControllerContext.PROJECT_PROBLEM_GRADE.getType(), record.getProblenGrade());
            System.out.println(dicName);
            stringObjectMap.put("problemTypeName", dicService.getDicName(ControllerContext.PROJECT_PROBLEM_TYPE.getType(),record.getProblemType()));
            stringObjectMap.put("problemGradeName", dicService.getDicName(ControllerContext.PROJECT_PROBLEM_GRADE.getType(),record.getProblenGrade()));
            return stringObjectMap;
        }).collect(Collectors.toList());
        Page<Map<String,Object>> o = new Page<>();
        o.setRecords(collect);
        o.setCurrent(hcProjectRemainProblemPage.getCurrent()    );
        o.setSize(hcProjectRemainProblemPage.getSize());
        o.setTotal(hcProjectRemainProblemPage.getTotal());
        return o;
    }
}
