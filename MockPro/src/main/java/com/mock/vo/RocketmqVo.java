package com.mock.vo;

import java.io.Serializable;

public class RocketmqVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int pn;
	
	private String ip;
	
	private int port;
	
	private String topicName;
	
	private String tag;
	
	private String key;
	
	private String values;
	
	private int times;
	
	private int mode;
	
	private int consume_flag;

	public int getPn() {
		return pn;
	}

	public void setPn(int pn) {
		this.pn = pn;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValues() {
		return values;
	}

	public void setValues(String values) {
		this.values = values;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public int getConsume_flag() {
		return consume_flag;
	}

	public void setConsume_flag(int consume_flag) {
		this.consume_flag = consume_flag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
}
