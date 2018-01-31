package com.mock.dao;

import java.util.List;

import com.mock.entity.RocketmqTopic;
import com.mock.vo.RocketmqVo;

public interface RocketmqTopicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RocketmqTopic record);

    int insertSelective(RocketmqTopic record);

    RocketmqTopic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RocketmqTopic record);

    int updateByPrimaryKey(RocketmqTopic record);
    
    List<RocketmqTopic> queryRocketmqTopicList(RocketmqVo rocketmqVo);
}