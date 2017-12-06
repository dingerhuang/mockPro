package com.mock.service.ipml;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.dao.BookMapper;
import com.mock.entity.Book;
import com.mock.service.BookService;
import com.mock.vo.BookQueryVo;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookMapper bookMapper;

	@Override
	public List<Book> getBookList(BookQueryVo bookQueryVo) {
		// TODO Auto-generated method stub
		return bookMapper.findBookList(bookQueryVo);
	}

	@Override
	public Book getBook(int id) {
		// TODO Auto-generated method stub
		return bookMapper.selectByPrimaryKey(id);
	}

	@Override
	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		bookMapper.insert(book);
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		bookMapper.updateByPrimaryKeySelective(book);
	}

	@Override
	public void delBook(int id) {
		// TODO Auto-generated method stub
		bookMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public void delBacthBook(ArrayList<Integer> ids) {
		// TODO Auto-generated method stub
		bookMapper.deleteBatchByIds(ids);
	}

}
