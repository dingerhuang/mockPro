package com.mock.service.ipml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.dao.BorrowTypeMapper;
import com.mock.entity.BorrowType;
import com.mock.service.BorrowTypeService;

@Service
public class BorrowTypeServiceImpl implements BorrowTypeService{

	@Autowired
	private BorrowTypeMapper borrowTypeMapper;
	
	@Override
	public List<BorrowType> getBorrowTypes() {
		// TODO Auto-generated method stub
		return borrowTypeMapper.selectBorrowTypes();
	}
	

}
