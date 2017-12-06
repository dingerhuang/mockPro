package com.mock.dao;

import java.util.ArrayList;
import java.util.List;
import com.mock.entity.A5;
import com.mock.vo.A5QueryVo;

public interface A5Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(A5 record);

    int insertSelective(A5 record);

    A5 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(A5 record);

    int updateByPrimaryKey(A5 record);
    
	List<A5> queryA5List(A5QueryVo a5QueryVo);

	void deleteBatchByIds(ArrayList<Integer> ids);
	
	A5 getLatestResult();
}