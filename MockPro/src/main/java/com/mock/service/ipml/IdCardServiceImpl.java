package com.mock.service.ipml;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.dao.IdCardMapper;
import com.mock.entity.IdCard;
import com.mock.service.IdCardService;
import com.mock.vo.IdCardQueryVo;

@Service
public class IdCardServiceImpl implements IdCardService{
	
	@Autowired
	private IdCardMapper idCardMapper;

	@Override
	public List<IdCard> getIdCardList(IdCardQueryVo idCardQueryVo) {
		// TODO Auto-generated method stub
		return idCardMapper.queryIdCardList(idCardQueryVo);
	}

	@Override
	public IdCard getIdCard(int id) {
		// TODO Auto-generated method stub
		return idCardMapper.selectByPrimaryKey(id);
	}

	@Override
	public void saveIdCard(IdCard idCard) {
		// TODO Auto-generated method stub
		idCardMapper.insertSelective(idCard);
	}

	@Override
	public void updateIdCard(IdCard idCard) {
		// TODO Auto-generated method stub
		idCardMapper.updateByPrimaryKeySelective(idCard);
	}

	@Override
	public void delIdCard(int id) {
		// TODO Auto-generated method stub
		idCardMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void delBatchIdCard(ArrayList<Integer> ids) {
		// TODO Auto-generated method stub
		idCardMapper.deleteBatchByIds(ids);
	}

}
