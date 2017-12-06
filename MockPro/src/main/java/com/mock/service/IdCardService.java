package com.mock.service;

import java.util.ArrayList;
import java.util.List;

import com.mock.entity.IdCard;
import com.mock.vo.IdCardQueryVo;

public interface IdCardService {

	public List<IdCard> getIdCardList(IdCardQueryVo idCardQueryVo);
	
	public IdCard getIdCard(int id);
	
	public void saveIdCard(IdCard idCard);
	
	public void updateIdCard(IdCard idCard);
	
	public void delIdCard(int id);
	
	public void delBatchIdCard(ArrayList<Integer> ids);
}
