package com.mock.dao;

import java.util.ArrayList;
import java.util.List;

import com.mock.entity.A7;
import com.mock.vo.A7QueryVo;

public interface A7Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(A7 record);

    int insertSelective(A7 record);

    A7 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(A7 record);

    int updateByPrimaryKey(A7 record);

	List<A7> queryA7List(A7QueryVo a7QueryVo);

	void deleteBatchByIds(ArrayList<Integer> ids);
	
	A7 getLatestResult();
}