package com.it.biz.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.it.tools.core.base.BaseModel;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 项目遗留问题表
 * </p>
 *
 * @author jiangwei
 * @since 2021-08-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class HcProjectRemainProblem extends BaseModel<HcProjectRemainProblem> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 项目id
     */
    @TableField("project_id")
    private Long projectId;

    /**
     * 项目编号
     */
    @TableField("project_code")
    private String projectCode;

    /**
     * 问题编码
     */
    @TableField("problem_code")
    private String problemCode;

    /**
     * 问题名称
     */
    @TableField("problem_name")
    private String problemName;

    /**
     * 问题来源(数据字典)
     */
    @TableField("problem_source")
    private String problemSource;

    /**
     * 关联风险id
     */
    @TableField("risk_id")
    private Long riskId;

    /**
     * 所属任务
     */
    @TableField("task_id")
    private Long taskId;

    /**
     * 提出人
     */
    @TableField("provide_man")
    private String provideMan;

    /**
     * 提出时间
     */
    @TableField("provide_time")
    private Date provideTime;

    /**
     * 问题等级(数据字典)
     */
    @TableField("problen_grade")
    private String problenGrade;

    /**
     * 问题类型(数据字典)
     */
    @TableField("problem_type")
    private String problemType;

    /**
     * 计划完成日期
     */
    @TableField("plan_finish_time")
    private Date planFinishTime;

    /**
     * 责任人
     */
    @TableField("responsible_man")
    private String responsibleMan;

    /**
     * 问题描述
     */
    @TableField("problem_desc")
    private String problemDesc;

    /**
     * 方案描述
     */
    @TableField("scheme_desc")
    private String schemeDesc;

    /**
     * 问题状态（0未解决 1解决中 2已关闭）
     */
    @TableField("problem_state")
    private String problemState;

    /**
     * 关闭日期
     */
    @TableField("close_time")
    private Date closeTime;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 乐观锁
     */
    @TableField("lock_version")
    private Long lockVersion;

    /**
     * 逻辑删除0：正常，1：删除
     */
    @TableField("logic_del")
    @TableLogic
    private String logicDel;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 创建人
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 更新人
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 租户id
     */
    @TableField("tenant_id")
    private Long tenantId;


    public static final String ID = "id";

    public static final String PROJECT_ID = "project_id";

    public static final String PROJECT_CODE = "project_code";

    public static final String PROBLEM_CODE = "problem_code";

    public static final String PROBLEM_NAME = "problem_name";

    public static final String PROBLEM_SOURCE = "problem_source";

    public static final String RISK_ID = "risk_id";

    public static final String TASK_ID = "task_id";

    public static final String PROVIDE_MAN = "provide_man";

    public static final String PROVIDE_TIME = "provide_time";

    public static final String PROBLEN_GRADE = "problen_grade";

    public static final String PROBLEM_TYPE = "problem_type";

    public static final String PLAN_FINISH_TIME = "plan_finish_time";

    public static final String RESPONSIBLE_MAN = "responsible_man";

    public static final String PROBLEM_DESC = "problem_desc";

    public static final String SCHEME_DESC = "scheme_desc";

    public static final String PROBLEM_STATE = "problem_state";

    public static final String CLOSE_TIME = "close_time";

    public static final String REMARK = "remark";

    public static final String LOCK_VERSION = "lock_version";

    public static final String LOGIC_DEL = "logic_del";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATE_BY = "create_by";

    public static final String UPDATE_BY = "update_by";

    public static final String TENANT_ID = "tenant_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
