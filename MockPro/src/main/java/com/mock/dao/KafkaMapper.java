package com.mock.dao;

import java.util.List;

import com.mock.entity.Kafka;
import com.mock.vo.KafkaQueryVo;

public interface KafkaMapper {

	int deleteByPrimaryKey(Integer id);

    int insert(Kafka record);

    int insertSelective(Kafka record);

    Kafka selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Kafka record);

    int updateByPrimaryKey(Kafka record);
    
    List<Kafka> queryKafkaList(KafkaQueryVo kafkaQueryVo);
}