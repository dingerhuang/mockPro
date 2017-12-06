package com.mock.service;

import java.util.ArrayList;
import java.util.List;
import com.mock.entity.Book;
import com.mock.vo.BookQueryVo;

public interface BookService {
	
	public List<Book> getBookList(BookQueryVo bookQueryVo);
	
	public Book getBook(int id);
	
	public void saveBook(Book book);
	
	public void updateBook(Book book);
	
	public void delBook(int id);
	
	public void delBacthBook(ArrayList<Integer> ids);
}
