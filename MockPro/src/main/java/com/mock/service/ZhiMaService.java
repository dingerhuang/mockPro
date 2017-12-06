package com.mock.service;

import java.util.ArrayList;
import java.util.List;

import com.mock.entity.Zhima;
import com.mock.vo.ZhimaQueryVo;

public interface ZhiMaService {

	public List<Zhima> getZhimaList(ZhimaQueryVo zhimaQueryVo);
	
	public Zhima getZhima(int id);
	
	public void saveZhima(Zhima zhima);
	
	public void updateZhima(Zhima zhima);
	
	public void delZhima(int id);
	
	public void delBatchZhima(ArrayList<Integer> ids);

}
