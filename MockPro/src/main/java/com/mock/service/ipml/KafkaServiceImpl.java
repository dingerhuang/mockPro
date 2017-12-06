package com.mock.service.ipml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.dao.KafkaMapper;
import com.mock.entity.Kafka;
import com.mock.service.KafkaService;
import com.mock.vo.KafkaQueryVo;

@Service
public class KafkaServiceImpl implements KafkaService {

	@Autowired
	private KafkaMapper kafkaMapper;
	
	@Override
	public List<Kafka> getKafkaList(KafkaQueryVo kafkaQueryVo) {
		// TODO Auto-generated method stub
		return kafkaMapper.queryKafkaList(kafkaQueryVo);
	}

	@Override
	public Kafka getKafka(int id) {
		// TODO Auto-generated method stub
		return kafkaMapper.selectByPrimaryKey(id);
	}

	@Override
	public void saveKafka(Kafka kafka) {
		// TODO Auto-generated method stub
		kafkaMapper.insertSelective(kafka);
	}

	@Override
	public void updateKafka(Kafka kafka) {
		// TODO Auto-generated method stub
		kafkaMapper.updateByPrimaryKeySelective(kafka);
	}

	@Override
	public void delKafka(int id) {
		// TODO Auto-generated method stub
		kafkaMapper.deleteByPrimaryKey(id);
	}

}
