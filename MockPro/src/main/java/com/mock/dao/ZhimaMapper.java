package com.mock.dao;

import java.util.ArrayList;
import java.util.List;

import com.mock.entity.Zhima;
import com.mock.vo.ZhimaQueryVo;

public interface ZhimaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zhima record);

    int insertSelective(Zhima record);

    Zhima selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zhima record);

    int updateByPrimaryKey(Zhima record);
    
	List<Zhima> queryZhimaList(ZhimaQueryVo zhimaQueryVo);

	void deleteBatchByIds(ArrayList<Integer> ids);
	
	Zhima getLatestResult();
}