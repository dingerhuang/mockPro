package com.mock.entity;

import java.util.HashMap;
import java.util.Map;

public class Message {
	
	private int errorCode;
	private String errorMsg;
	private Map<String, Object> extend = new HashMap<String, Object>();
	
	public static Message sucess(){
		Message message = new Message();
		message.setErrorCode(200);
		message.setErrorMsg("sucess");
		return message;
	}
	
	public static Message fail(){
		Message message = new Message();
		message.setErrorCode(500);
		message.setErrorMsg("failed");
		return message;
	}
	
	public Message add(String key,Object value){
		this.getExtend().put(key, value);
		return this;
		
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Map<String, Object> getExtend() {
		return extend;
	}
	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	
	
	
	
}
