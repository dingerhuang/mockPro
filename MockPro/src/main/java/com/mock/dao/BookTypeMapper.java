package com.mock.dao;

import java.util.List;

import com.mock.entity.BookType;

public interface BookTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BookType record);

    int insertSelective(BookType record);

    BookType selectByPrimaryKey(Long id);
    
    List<BookType> selectBookTypes();

    int updateByPrimaryKeySelective(BookType record);

    int updateByPrimaryKey(BookType record);
}