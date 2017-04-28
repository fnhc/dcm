package com.chinawiserv.dsp.dcs.dcm.common.bean.response;

import java.util.ArrayList;
import java.util.List;

public class ListResult<T> extends HandleResult {
	private static final long serialVersionUID = 3170304034938022011L;
	
	private List<T> rows = null;

	public ListResult(){
		rows = new ArrayList<T>();
	}

	public void add(T element) {
		if (this.rows != null) {
			this.rows.add(element);
		}
	}
	
	public void addAll(ArrayList<T> list) {
		if (this.rows != null) {
			this.rows.addAll(list);
		}
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
