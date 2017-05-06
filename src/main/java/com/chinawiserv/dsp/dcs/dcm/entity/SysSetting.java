package com.chinawiserv.dsp.dcs.dcm.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 系统设置表
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@TableName("sys_setting")
public class SysSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(type= IdType.UUID)
	private String id;
    /**
     * KEY
     */
	@TableField("sys_key")
	private String sysKey;
    /**
     * 名称
     */
	@TableField("sys_name")
	private String sysName;
    /**
     * 值
     */
	@TableField("sys_value")
	private String sysValue;
    /**
     * 排序
     */
	private Integer sort;
    /**
     * 说明
     */
	@TableField("sys_desc")
	private String sysDesc;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSysKey() {
		return sysKey;
	}

	public void setSysKey(String sysKey) {
		this.sysKey = sysKey;
	}

	public String getSysName() {
		return sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
	}

	public String getSysValue() {
		return sysValue;
	}

	public void setSysValue(String sysValue) {
		this.sysValue = sysValue;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getSysDesc() {
		return sysDesc;
	}

	public void setSysDesc(String sysDesc) {
		this.sysDesc = sysDesc;
	}

}
