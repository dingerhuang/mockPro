package com.mock.dao;

import java.util.ArrayList;
import java.util.List;

import com.mock.entity.IdCard;
import com.mock.vo.IdCardQueryVo;

public interface IdCardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IdCard record);

    int insertSelective(IdCard record);

    IdCard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IdCard record);

    int updateByPrimaryKey(IdCard record);
    
	List<IdCard> queryIdCardList(IdCardQueryVo idCardQueryVo);

	void deleteBatchByIds(ArrayList<Integer> ids);
	
	IdCard getLatestResult();
}