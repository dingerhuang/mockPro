package com.mock.service;

import java.util.List;

import com.mock.entity.Kafka;
import com.mock.vo.KafkaQueryVo;

public interface KafkaService {

	public List<Kafka> getKafkaList(KafkaQueryVo kafkaQueryVo);
	
	public Kafka getKafka(int id);
	
	public void saveKafka(Kafka kafka);
	
	public void updateKafka(Kafka kafka);
	
	public void delKafka(int id);
}
