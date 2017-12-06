package com.mock.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BookQueryVo implements Serializable{

	/*
	 *序列号 
	 */
	private String ISBNNumber;
	/*
	 * 图示名称
	 */
	private String bookName;
	/*
	 * 图书类型
	 */
	private String book_type;
	/*
	 * 页数
	 */
	private int pn;
	
	public String getISBNNumber() {
		return ISBNNumber;
	}
	public void setISBNNumber(String iSBNNumber) {
		ISBNNumber = iSBNNumber;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBook_type() {
		return book_type;
	}
	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}
	public int getPn() {
		return pn;
	}
	public void setPn(int pn) {
		this.pn = pn;
	}


}
