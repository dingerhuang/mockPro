package com.mock.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("KafkaProducer")
public class KafkaConfig {

	private String acks;
	private String buffermemory;
	private String keyserializer;
	private String valueserializer;
	
	public String getAcks() {
		return acks;
	}
	@Value("${acks}")
	public void setAcks(String acks) {
		this.acks = acks;
	}
	public String getBuffermemory() {
		return buffermemory;
	}
	@Value("${buffer.memory}")
	public void setBuffermemory(String buffermemory) {
		this.buffermemory = buffermemory;
	}
	public String getKeyserializer() {
		return keyserializer;
	}
	@Value("${key.serializer}")
	public void setKeyserializer(String keyserializer) {
		this.keyserializer = keyserializer;
	}
	public String getValueserializer() {
		return valueserializer;
	}
	@Value("${value.serializer}")
	public void setValueserializer(String valueserializer) {
		this.valueserializer = valueserializer;
	}
}
