package com.mock.dao;

import java.util.List;

import com.mock.entity.Book;
import com.mock.vo.BookQueryVo;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);
    
    void deleteBatchByIds(List<Integer> ids);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);
    
    Book selectOneById(Integer id);
    
    List<Book> selectAll();

    List<Book> findBookList(BookQueryVo bookQueryVo);
    
    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}