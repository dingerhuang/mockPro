package com.mock.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Book {
    private Integer id;

    @NotNull(message="图书序列号不能为空")
    private String ISBNNumber;

    @NotNull(message="图书名字不能为空")
    private String bookName;

    @Size(min=1,max=10,message="单价不在范围内")
    private Float price;

    private String press;

    private String writer;

    private String book_type;

    private String borrow_type;
    
    private BookType bookType;
    
    private BorrowType borrowType;
    
    public Book() {
		// TODO Auto-generated constructor stub
    	super();
	}

    
	/**
	 * @param id
	 * @param iSBNNumber
	 * @param bookName
	 * @param price
	 * @param press
	 * @param writer
	 * @param book_type
	 * @param borrow_type
	 */
	public Book(Integer id, String iSBNNumber, String bookName, Float price, String press, String writer,
			String book_type, String borrow_type) {
		this.id = id;
		ISBNNumber = iSBNNumber;
		this.bookName = bookName;
		this.price = price;
		this.press = press;
		this.writer = writer;
		this.book_type = book_type;
		this.borrow_type = borrow_type;
	}


	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getISBNNumber() {
        return ISBNNumber;
    }

    public void setISBNNumber(String ISBNNumber) {
        this.ISBNNumber = ISBNNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getBook_type() {
        return book_type;
    }

    public void setBook_type(String book_type) {
        this.book_type = book_type;
    }

    public String getBorrow_type() {
        return borrow_type;
    }

    public void setBorrow_type(String borrow_type) {
        this.borrow_type = borrow_type;
    }

	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

	public BorrowType getBorrowType() {
		return borrowType;
	}

	public void setBorrowType(BorrowType borrowType) {
		this.borrowType = borrowType;
	}
}