package com.mock.constant;

public enum EnvEnum {

	BetaA(1,"10.40.10.197"),
	BetaB(2,"10.40.10.152"),
	BetaC(3,"10.40.10.154"),
	BetaD(4,"10.40.10.156"),
	BetaE(4,"10.40.10.158");

	private int code;
	private String ip;
	
	
	/**
	 * @param code
	 * @param ip
	 */
	private EnvEnum(int code, String ip) {
		this.code = code;
		this.ip = ip;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
