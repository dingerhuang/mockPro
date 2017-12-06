package com.mock.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")//根节点
public class YS {


	/*
	 * resCode
	 * 成功:0000
	 * 处理中:0001
	 * 失败:0002
	 */
	private Integer id;
	private Integer priority;
	private Integer resCode;
	private String message;
	private String remark;
	private String timeout;
	/**
	 * 
	 */
	public YS() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * @param id
	 * @param priority
	 * @param resCode
	 * @param message
	 * @param remark
	 * @param timeout
	 */
	public YS(Integer id, Integer priority, Integer resCode, String message, String remark, String timeout) {
		super();
		this.id = id;
		this.priority = priority;
		this.resCode = resCode;
		this.message = message;
		this.remark = remark;
		this.timeout = timeout;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	@XmlElement
	//该属性作为xml的element，且可以增加属性(name="NewElementName")，那么生成的xml串的elment的标签是NewElementName
	public Integer getResCode() {
		return resCode;
	}
	public void setResCode(Integer resCode) {
		this.resCode = resCode;
	}
	
	@XmlElement
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@XmlElement
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTimeout() {
		return timeout;
	}
	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}
	
	
	
	
}
