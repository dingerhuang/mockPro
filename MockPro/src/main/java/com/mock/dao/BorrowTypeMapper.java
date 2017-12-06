package com.mock.dao;

import java.util.List;

import com.mock.entity.BorrowType;

public interface BorrowTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BorrowType record);

    int insertSelective(BorrowType record);

    BorrowType selectByPrimaryKey(Integer id);

    List<BorrowType> selectBorrowTypes();
    
    int updateByPrimaryKeySelective(BorrowType record);

    int updateByPrimaryKey(BorrowType record);

}