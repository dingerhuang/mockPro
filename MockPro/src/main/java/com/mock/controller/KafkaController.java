package com.mock.controller;

import java.util.List;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import com.mock.constant.EnvEnum;
import com.mock.entity.Kafka;
import com.mock.entity.KafkaConfig;
import com.mock.entity.Message;
import com.mock.service.KafkaService;
import com.mock.vo.KafkaQueryVo;

@Controller
@RequestMapping(value="/Kafka")
public class KafkaController {
	private final static Logger log = LogManager.getLogger(KafkaController.class);
	@Autowired
	private KafkaService kafkaService;
	
	@Autowired
	private KafkaConfig kafkaProducer;
	
	/*
	 * 返回发送记录
	 */
	@RequestMapping(value="/lists")
	@ResponseBody
	public Message getKafkaList(KafkaQueryVo kafkaQueryVo){
		
		try {
			int pn = kafkaQueryVo.getPn();
			PageHelper.startPage(pn,15);
			
			List<Kafka> kafkalist=kafkaService.getKafkaList(kafkaQueryVo);
			PageInfo pageInfo = new PageInfo(kafkalist,5);
			
			return Message.sucess().add("pageInfo", pageInfo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return Message.fail();
	}
	/*
	 * 返回基本kafka配置
	 */
	@RequestMapping(value="/conf")
	@ResponseBody
	public String getKafkaConf(){
		JsonObject datas = new JsonObject();
		JsonObject ips = new JsonObject();
		for(EnvEnum envEnum : EnvEnum.values()) {
			 //System.out.println(envEnum+envEnum.getIp()+envEnum.getCode());
			 ips.addProperty(envEnum.toString(), envEnum.getIp());
		}
		String acks = kafkaProducer.getAcks();
		String bufferMemory = kafkaProducer.getBuffermemory();
		String keySerializer = kafkaProducer.getKeyserializer();
		String valueSerializer = kafkaProducer.getValueserializer();
		datas.addProperty("acks", acks);
		datas.addProperty("bufferMemory", bufferMemory);
		datas.addProperty("keySerializer", keySerializer);
		datas.addProperty("valueSerializer", valueSerializer);
		datas.add("ips", ips);
		datas.addProperty("port", com.mock.constant.Constants.KAFKA_PORT);
		
		return datas.toString();
	}
	/*
	 * 发送kafka消息
	 */
	@RequestMapping("/send")
	@ResponseBody
	public Message sendKafaMessage(HttpServletRequest request,HttpServletResponse response,Kafka kafka){
		
		String ip = request.getParameter("ip");
		String port = request.getParameter("port");
		String topicName = request.getParameter("topicName");
		String acks = request.getParameter("acks");
		String bufferMemory = request.getParameter("bufferMemory");
		String keySerializer = request.getParameter("keySerializer");
		String valueSerializer = request.getParameter("valueSerializer");
		String key = request.getParameter("key");
		String values = request.getParameter("values");
		int times = Integer.parseInt(request.getParameter("times"));
		Properties props = new Properties();
		props.put("bootstrap.servers", ip+":"+port);
		props.put("acks", acks);
		//buffer.memory  为int
		props.put("buffer.memory", Integer.parseInt(bufferMemory));
		props.put("key.serializer", keySerializer);
		props.put("value.serializer",valueSerializer);
		KafkaProducer<String, String> producer = new KafkaProducer<String,String>(props);
		try{
			for(int i=0;i<times;i++){
				producer.send(new ProducerRecord<String, String>(topicName, key,values));
				kafkaService.saveKafka(kafka);
				log.info("Message sent successfully");
			}
		}catch (Exception e) {
			e.printStackTrace();
			return Message.fail();
		}finally {
			producer.close();
		}
		log.info("success");
		return Message.sucess();
	}
	/*
	 * 消费消息
	 */
}
