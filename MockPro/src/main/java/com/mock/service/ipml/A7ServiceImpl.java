package com.mock.service.ipml;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.dao.A7Mapper;
import com.mock.entity.A7;
import com.mock.service.A7Service;
import com.mock.vo.A7QueryVo;

@Service
public class A7ServiceImpl implements A7Service{
	
	@Autowired
	private A7Mapper a7Mapper;
	
	@Override
	public List<A7> getA7List(A7QueryVo a7QueryVo) {
		// TODO Auto-generated method stub
		return a7Mapper.queryA7List(a7QueryVo);
	}

	@Override
	public A7 getA7(int id) {
		// TODO Auto-generated method stub
		return a7Mapper.selectByPrimaryKey(id);
	}

	@Override
	public void saveA7(A7 a7) {
		// TODO Auto-generated method stub
		a7Mapper.insertSelective(a7);
	}

	@Override
	public void updateA7(A7 a7) {
		// TODO Auto-generated method stub
		a7Mapper.updateByPrimaryKeySelective(a7);
	}

	@Override
	public void delA7(int id) {
		// TODO Auto-generated method stub
		a7Mapper.deleteByPrimaryKey(id);
	}

	@Override
	public void delBatchA7(ArrayList<Integer> ids) {
		// TODO Auto-generated method stub
		System.out.println("123");
		System.out.println(ids.toString());
		a7Mapper.deleteBatchByIds(ids);
	}

}
