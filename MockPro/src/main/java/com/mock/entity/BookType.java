package com.mock.entity;

public class BookType {
    private Long id;

    private String type_code;

    private String type_value;
    
    

    /**
	 * 
	 */
	public BookType() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param id
	 * @param type_code
	 * @param type_value
	 */
	public BookType(Long id, String type_code, String type_value) {
		super();
		this.id = id;
		this.type_code = type_code;
		this.type_value = type_value;
	}


	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType_code() {
        return type_code;
    }

    public void setType_code(String type_code) {
        this.type_code = type_code;
    }

    public String getType_value() {
        return type_value;
    }

    public void setType_value(String type_value) {
        this.type_value = type_value;
    }
}