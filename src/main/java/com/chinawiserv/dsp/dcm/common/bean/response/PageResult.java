package com.chinawiserv.dsp.dcm.common.bean.response;

import com.baomidou.mybatisplus.plugins.Page;

import java.util.HashMap;

public class PageResult extends ListResult<HashMap<String, Object>> {

	private static final long serialVersionUID = -8304845128694340426L;

	/**
	 * 总记录数
	 */
	private int total;

	public PageResult(Page page) {
		setRows(page.getRecords());
		setTotal(page.getTotal());
	}
	

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
