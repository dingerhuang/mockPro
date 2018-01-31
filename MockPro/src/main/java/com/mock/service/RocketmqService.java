package com.mock.service;

import java.util.List;

import com.mock.entity.RocketmqTopic;
import com.mock.vo.RocketmqVo;

public interface RocketmqService {

	public List<RocketmqTopic> getRocketmqTopics(RocketmqVo rocketmqVo);
	
	public RocketmqTopic getTopic(int id);
	
	public boolean saveTopic(RocketmqTopic rocketmqTopic);
	
	public boolean updateTopic(RocketmqTopic rocketmqTopic);
	
	public boolean delTopic(int id);
	
}
