package com.mock.entity;

public class Kafka {
    private Integer id;

	private String ip;

	private Integer port;

	private String topicName;

	private String acks;

	private Integer bufferMemory;

	private String keySerializer;

	private String valueSerializer;

	private Integer key;

	private Integer values;

	private Integer times;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getAcks() {
		return acks;
	}

	public void setAcks(String acks) {
		this.acks = acks;
	}

	public Integer getBufferMemory() {
		return bufferMemory;
	}

	public void setBufferMemory(Integer bufferMemory) {
		this.bufferMemory = bufferMemory;
	}

	public String getKeySerializer() {
		return keySerializer;
	}

	public void setKeySerializer(String keySerializer) {
		this.keySerializer = keySerializer;
	}

	public String getValueSerializer() {
		return valueSerializer;
	}

	public void setValueSerializer(String valueSerializer) {
		this.valueSerializer = valueSerializer;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public Integer getValues() {
		return values;
	}

	public void setValues(Integer values) {
		this.values = values;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}
}