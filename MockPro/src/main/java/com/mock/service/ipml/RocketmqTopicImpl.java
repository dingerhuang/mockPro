package com.mock.service.ipml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mchange.v2.sql.filter.SynchronizedFilterStatement;
import com.mock.dao.RocketmqTopicMapper;
import com.mock.entity.RocketmqTopic;
import com.mock.service.RocketmqService;
import com.mock.vo.RocketmqVo;

@Service
public class RocketmqTopicImpl implements RocketmqService{
	
	@Autowired
	private RocketmqTopicMapper rocketmqTopicMapper;

	@Override
	public List<RocketmqTopic> getRocketmqTopics(RocketmqVo rocketmqVo) {
		// TODO Auto-generated method stub
		
		return rocketmqTopicMapper.queryRocketmqTopicList(rocketmqVo);
	}

	@Override
	public RocketmqTopic getTopic(int id) {
		// TODO Auto-generated method stub
		return rocketmqTopicMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean saveTopic(RocketmqTopic rocketmqTopic) {
		// TODO Auto-generated method stub
		try {
			rocketmqTopicMapper.insertSelective(rocketmqTopic);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateTopic(RocketmqTopic rocketmqTopic) {
		// TODO Auto-generated method stub
		try {
			rocketmqTopicMapper.updateByPrimaryKeySelective(rocketmqTopic);
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}
		
	@Override
	public boolean delTopic(int id) {
		// TODO Auto-generated method stub
		try {
			rocketmqTopicMapper.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}

}
