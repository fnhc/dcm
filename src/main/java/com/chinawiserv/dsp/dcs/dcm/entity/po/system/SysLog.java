package com.chinawiserv.dsp.dcs.dcm.entity.po.system;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 访问日志表
 * </p>
 *
 * @author zhanf
 * @since 2017-05-17
 */
@TableName("sys_log")
public class SysLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 操作人Id
     */
	private String operator;
    /**
     * 操作时间
     */
	@TableField("operate_time")
	private Date operateTime;
    /**
     * 操作类型
     */
	@TableField("operate_type")
	private String operateType;
    /**
     * 操作描述
     */
	@TableField("operate_desc")
	private String operateDesc;
    /**
     * 操作详情
     */
	@TableField("operate_detail")
	private String operateDetail;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String getOperateDesc() {
		return operateDesc;
	}

	public void setOperateDesc(String operateDesc) {
		this.operateDesc = operateDesc;
	}

	public String getOperateDetail() {
		return operateDetail;
	}

	public void setOperateDetail(String operateDetail) {
		this.operateDetail = operateDetail;
	}

}
