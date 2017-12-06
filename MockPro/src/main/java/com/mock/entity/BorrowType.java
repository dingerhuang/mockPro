package com.mock.entity;

public class BorrowType {
    private Integer id;

    private String borrow_type;

    private Float borrow_value;
    
    

    /**
	 * 
	 */
	public BorrowType() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param id
	 * @param borrow_type
	 * @param borrow_value
	 */
	public BorrowType(Integer id, String borrow_type, Float borrow_value) {
		this.id = id;
		this.borrow_type = borrow_type;
		this.borrow_value = borrow_value;
	}


	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBorrow_type() {
        return borrow_type;
    }

    public void setBorrow_type(String borrow_type) {
        this.borrow_type = borrow_type;
    }

    public Float getBorrow_value() {
        return borrow_value;
    }

    public void setBorrow_value(Float borrow_value) {
        this.borrow_value = borrow_value;
    }
}