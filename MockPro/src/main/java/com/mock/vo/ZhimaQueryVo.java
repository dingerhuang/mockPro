package com.mock.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ZhimaQueryVo implements Serializable{
	
	private int pn;
	private Integer priority;
	private Integer errorCode;
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
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

}
