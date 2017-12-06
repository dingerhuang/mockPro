package com.mock.service.ipml;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.dao.ZhimaMapper;
import com.mock.entity.Zhima;
import com.mock.service.ZhiMaService;
import com.mock.vo.ZhimaQueryVo;

@Service
public class ZhiMaServiceImpl implements ZhiMaService{

	@Autowired
	private ZhimaMapper zhimaMapper;
	
	@Override
	public List<Zhima> getZhimaList(ZhimaQueryVo zhimaQueryVo) {
		// TODO Auto-generated method stub
		return zhimaMapper.queryZhimaList(zhimaQueryVo);
	}

	@Override
	public Zhima getZhima(int id) {
		// TODO Auto-generated method stub
		return zhimaMapper.selectByPrimaryKey(id);
	}

	@Override
	public void saveZhima(Zhima zhima) {
		// TODO Auto-generated method stub
		zhimaMapper.insertSelective(zhima);
		
	}

	@Override
	public void updateZhima(Zhima zhima) {
		// TODO Auto-generated method stub
		zhimaMapper.updateByPrimaryKeySelective(zhima);
	}

	@Override
	public void delZhima(int id) {
		// TODO Auto-generated method stub
		zhimaMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void delBatchZhima(ArrayList<Integer> ids) {
		// TODO Auto-generated method stub
		zhimaMapper.deleteBatchByIds(ids);
	}

}
