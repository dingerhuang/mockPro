package com.mock.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class YSQueryVo implements Serializable{
	
	private int pn;
	private Integer priority;
	private Integer resCode;
	public int getPn() {
		return pn;
	}
	public void setPn(int pn) {
		this.pn = pn;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getResCode() {
		return resCode;
	}
	public void setResCode(Integer resCode) {
		this.resCode = resCode;
	}

	
}
