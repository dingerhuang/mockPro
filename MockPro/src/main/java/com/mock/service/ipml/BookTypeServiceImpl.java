package com.mock.service.ipml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.dao.BookTypeMapper;
import com.mock.entity.BookType;
import com.mock.service.BookTypeService;


@Service
public class BookTypeServiceImpl implements BookTypeService{
	
	@Autowired
	BookTypeMapper bookTypeMapper;

	@Override
	public List<BookType> getBookTypes() {
		// TODO Auto-generated method stub
		return bookTypeMapper.selectBookTypes();
	}



}
