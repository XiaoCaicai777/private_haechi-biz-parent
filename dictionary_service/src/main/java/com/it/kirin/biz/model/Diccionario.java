package com.it.kirin.biz.model;

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
 * 
 * </p>
 *
 * @author jiangwei
 * @since 2021-08-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Diccionario extends BaseModel<Diccionario> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 字典编码
     */
    @TableField("dic_code")
    private String dicCode;

    /**
     * 字典编码描述
     */
    @TableField("dic_name")
    private String dicName;

    /**
     * 字典类型code
     */
    @TableField("dic_type_code")
    private String dicTypeCode;

    /**
     * 租户id
     */
    @TableField("tenant_id")
    private Integer tenantId;

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
     * 逻辑删除
     */
    @TableField("logic_del")
    @TableLogic
    private Integer logicDel;


    public static final String ID = "id";

    public static final String DIC_CODE = "dic_code";

    public static final String DIC_NAME = "dic_name";

    public static final String DIC_TYPE_CODE = "dic_type_code";

    public static final String TENANT_ID = "tenant_id";

    public static final String CREATE_BY = "create_by";

    public static final String UPDATE_BY = "update_by";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String LOGIC_DEL = "logic_del";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
