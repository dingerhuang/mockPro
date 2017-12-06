package com.mock.service;

import java.util.ArrayList;
import java.util.List;

import com.mock.entity.A5;
import com.mock.vo.A5QueryVo;

public interface A5Service {

	public List<A5> getA5List(A5QueryVo a5QueryVo);
	
	public A5 getA5(int id);
	
	public void saveA5(A5 a5);
	
	public void updateA5(A5 a5);
	
	public void delA5(int id);
	
	public void delBatchA5(ArrayList<Integer> ids);

}
