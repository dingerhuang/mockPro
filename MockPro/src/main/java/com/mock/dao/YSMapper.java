package com.mock.dao;

import java.util.ArrayList;
import java.util.List;

import com.mock.entity.YS;
import com.mock.vo.YSQueryVo;

public interface YSMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YS record);

    int insertSelective(YS record);

    YS selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YS record);

    int updateByPrimaryKey(YS record);
    
	List<YS> queryYsList(YSQueryVo ysQueryVo);

	void deleteBatchByIds(ArrayList<Integer> ids);
    
    YS getLatestResult();
}