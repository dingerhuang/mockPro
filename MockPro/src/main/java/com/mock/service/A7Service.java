package com.mock.service;

import java.util.ArrayList;
import java.util.List;

import com.mock.entity.A7;
import com.mock.vo.A7QueryVo;

public interface A7Service {

	public List<A7> getA7List(A7QueryVo a7QueryVo);
	
	public A7 getA7(int id);
	
	public void saveA7(A7 a7);
	
	public void updateA7(A7 a7);
	
	public void delA7(int id);
	
	public void delBatchA7(ArrayList<Integer> ids);

}
