package com.chinawiserv.dsp.dcm.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author zhanf
 * @since 2017-04-14
 */
@TableName("sys_dept")
public class Dept extends Model<Dept> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 部门名称
     */
	private String deptName;
    /**
     * 描述
     */
	private String deptDesc;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptDesc() {
		return deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
