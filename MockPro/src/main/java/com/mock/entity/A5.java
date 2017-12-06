package com.mock.entity;


public class A5 {
    private Integer id;

    private Integer priority;

    private Integer errorCode;

    private String errorMsg;

    private String data;

    private Integer timeout;

    private Integer times;
    
    

    /**
	 * @param id
	 * @param priority
	 * @param errorCode
	 * @param errorMsg
	 * @param data
	 * @param timeout
	 * @param times
	 */
	public A5(Integer id, Integer priority, Integer errorCode, String errorMsg, String data, Integer timeout,
			Integer times) {
		this.id = id;
		this.priority = priority;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.data = data;
		this.timeout = timeout;
		this.times = times;
	}


	/**
	 * 
	 */
	public A5() {
		super();
		// TODO Auto-generated constructor stub
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

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
}