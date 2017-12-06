package com.mock.service.ipml;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.dao.A5Mapper;
import com.mock.entity.A5;
import com.mock.service.A5Service;
import com.mock.vo.A5QueryVo;

@Service
public class A5ServiceImpl implements A5Service {

	@Autowired
	private A5Mapper a5Mapper;
	@Override
	public List<A5> getA5List(A5QueryVo a5QueryVo) {
		// TODO Auto-generated method stub
		return a5Mapper.queryA5List(a5QueryVo);
	}

	@Override
	public A5 getA5(int id) {
		// TODO Auto-generated method stub
		return a5Mapper.selectByPrimaryKey(id);
	}

	@Override
	public void saveA5(A5 a5) {
		// TODO Auto-generated method stub
		a5Mapper.insertSelective(a5);
	}

	@Override
	public void updateA5(A5 a5) {
		// TODO Auto-generated method stub
		a5Mapper.updateByPrimaryKeySelective(a5);
	}

	@Override
	public void delA5(int id) {
		// TODO Auto-generated method stub
		a5Mapper.deleteByPrimaryKey(id);
	}

	@Override
	public void delBatchA5(ArrayList<Integer> ids) {
		// TODO Auto-generated method stub
		a5Mapper.deleteBatchByIds(ids);
	}

}
