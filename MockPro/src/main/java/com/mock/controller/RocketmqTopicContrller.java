package com.mock.controller;

import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.mock.entity.Message;
import com.mock.entity.RocketmqTopic;
import com.mock.service.RocketmqService;
import com.mock.vo.RocketmqVo;


@Controller
@RequestMapping(value="/Rocketmq")
public class RocketmqTopicContrller {

	private final static Logger log = LogManager.getLogger(RocketmqTopicContrller.class);
	@Autowired
	private RocketmqService rocketmqService;
	
	/*	
	 * 查询topic列表
	 */
	@RequestMapping(value="/lists")
	@ResponseBody
	public Message getTopicList(RocketmqVo rocketmqVo){
		try {
			//第几页及每页多少条
			int pn = rocketmqVo.getPn();
			PageHelper.startPage(pn, 15);
			//获取数据
			List<RocketmqTopic> topicList = rocketmqService.getRocketmqTopics(rocketmqVo);
			//丢到pageinfo,默认展示5页
			PageInfo pageInfo = new PageInfo<>(topicList,5);
			
			return Message.sucess().add("pageInfo", pageInfo);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Message.fail();
	}
	
	/*
	 * 根据ID查询topic
	 */
	@RequestMapping(value="{id}")
	@ResponseBody
	public Message queryRocketmqTopic(@PathVariable("id")int id){
		try {
			RocketmqTopic rocketmqTopic = rocketmqService.getTopic(id);
			return Message.sucess().add("rocketmqTopic", rocketmqTopic);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Message.fail();
	}
	
	
	/*
	 * 新增topic
	 */
	@RequestMapping(value="/add")
	@ResponseBody
	public Message addRocketmqTopic(RocketmqTopic rocketmqTopic){
		try {
			boolean flag = rocketmqService.saveTopic(rocketmqTopic);
			if(flag){
				return Message.sucess();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Message.fail();
	}
	
	
	/*
	 * 修改topic
	 * 
	 */
	@RequestMapping(value="/update")
	@ResponseBody
	public Message updateRocketmqTopic(RocketmqTopic rocketmqTopic){
		try {
			boolean flag = rocketmqService.updateTopic(rocketmqTopic);
			if(flag){
				return Message.sucess();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Message.fail();
	} 
	
	
	/*
	 * 删除topic
	 */
	@RequestMapping(value="/del/{id}")
	@ResponseBody
	public Message delRocketmqTopic(@PathVariable("id")String id){
		try {
			boolean flag = rocketmqService.delTopic(Integer.parseInt(id));
			if(flag){
				return Message.sucess();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Message.fail();
	}
	
	/*
	 * 生产消息
	 */
	@RequestMapping(value="/produce")
	@ResponseBody
	public Message produceMqMessage(RocketmqTopic rocketmqTopic) throws MQClientException, InterruptedException{
		//创建producer
		DefaultMQProducer producer = new DefaultMQProducer("producer_mock");
		//指定nameServer地址,多个nameServer以分号隔开
		String namesrvAddr = rocketmqTopic.getIp()+":"+rocketmqTopic.getPort();
		producer.setNamesrvAddr(namesrvAddr);
		producer.setVipChannelEnabled(false);
		//producer.setRetryTimesWhenSendFailed(3); // 发送消息到broker失败，重试次数，默认是2次 
		//producer.setInstanceName(UUID.randomUUID().toString());  可以不用设置
		//初始化producer
		try {
			producer.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String topic = rocketmqTopic.getTopicName();
		String tag = rocketmqTopic.getTag();
		String key = rocketmqTopic.getKey();
		String body = rocketmqTopic.getValues();
		log.info("\r\nrocketmq namesrvAddr:"+namesrvAddr+"\r\n"+"rocketmq topic:"+topic+"\r\nrocketmq tag:"+
		tag+"\r\nrocketmq key:"+key);
		log.info("\r\nrocketmq body:"+body);
		
		//字符串转json
//		Gson gson = new Gson();
//		String jsonbody = gson.toJson(body);
		org.apache.rocketmq.common.message.Message msg = new org.apache.rocketmq.common.message.Message(
				topic,tag,key,(body).getBytes());
	    try{
	    	if(rocketmqTopic.getTimes() >= 1){
	    		for(int i =0;i<rocketmqTopic.getTimes();i++){
	    			producer.send(msg);
	                //写数据库
	                rocketmqService.saveTopic(rocketmqTopic);
	                log.info("send mqMessage success!");
	    		}
	    	}

            return Message.sucess();
            
        } catch(Exception e){
            e.printStackTrace();
            log.error("send mqMessage failed!");
            return Message.fail();
        }finally {
        	//停止Producer
            producer.shutdown();
            log.info("finally shutdown mq!");
       
		}
	   
        
	}
	
	/*
	 * 消费消息
	 * mode=1表示长连接轮询拉取消息，mode=2表示主动拉取（监听模式）
	 * consume_flag=1表示消费成功，2表示消费失败（不回写ACK），3表示超时
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/consume")
	@ResponseBody
	public Message consumeMqMessage(RocketmqTopic rocketmqTopic) throws MQClientException{
		int mode = rocketmqTopic.getMode();
		String topic = rocketmqTopic.getTopicName();
		int flag = rocketmqTopic.getConsume_flag();
		String tag = rocketmqTopic.getTag();
		String namesrvAddr = rocketmqTopic.getIp()+":"+rocketmqTopic.getPort();
		if(mode == 1){
			//创建consumer,consumer_mock为消费组名
			DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_mock");
			/*
			 * 设置consumer第一次启动是从队列头部消费还是尾部
			 * 如果非第一次启动，那么按照上次消费的位置继续消费
			 */
			consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
			//指定nameServer地址
			consumer.setNamesrvAddr(namesrvAddr);
			//设置消费方式，默认集群消费，随机轮询发送到consumerGroup下的某个消费者
			consumer.setMessageModel(MessageModel.BROADCASTING);
			//订阅topic下的tag，多个tag以||分隔
			if(!tag.isEmpty()){
				consumer.subscribe(topic, tag);
				log.info("已订阅topic:"+topic+"tag:"+tag);
			}else{
				/*
				 * 可以订阅多个topic
				 * consumer.subscribe(topic2, "*");
				 */
				log.info("已订阅topic"+topic+"下所有tag");
				consumer.subscribe(topic, "*");
			}
			log.info("开始监听topic:"+topic);
			//注册消费的监听
			consumer.registerMessageListener(new MessageListenerConcurrently() {
				@Override
				public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context){
					for(MessageExt msg : msgs){
						 //开始消费
						 try {
							if(flag == 1 && msg.getTags() != null){
								log.info("开始消费topic:"+msg.getTopic()+" tag:"+msg.getTags());
							}else if(flag == 1 && msg.getTags() == null){
								log.info("开始消费topic:"+msg.getTopic());
							}else{
								log.info("topic:"+msg.getTopic()+"消费失败");
								return ConsumeConcurrentlyStatus.RECONSUME_LATER;
							}
						} catch (Exception e) {
							// TODO: handle exception
							if(msg.getReconsumeTimes() == 3){  
                                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;  
                            }
							return ConsumeConcurrentlyStatus.RECONSUME_LATER;
						}
					 }
					
					return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
				}
			});
			/*
             * Consumer对象在使用之前必须要调用start初始化，初始化一次即可
             */
            consumer.start();
            log.info("consume start");
            
            return Message.sucess();
		//监听模式	,公司用的长连接模式
		}else{
			log.info(mode+"---------------------");
			final DefaultMQPullConsumer consumer = new DefaultMQPullConsumer("consumerPullLiu"); 
			consumer.setNamesrvAddr(namesrvAddr);
			consumer.start();
			
			try {
				Set<MessageQueue> mqs = consumer.fetchSubscribeMessageQueues(topic); 
				log.info("mqs.size() " + mqs.size());
				// 必须加上此监听才能在消费过后，自动回写消费进度  
	            consumer.registerMessageQueueListener(topic, null);
	              
	            // 循环每一个队列  
	            for(MessageQueue mq: mqs){  
	                System.out.println("consume message from queue: " + mq + " mqsize = " + mqs.size());  
	                int cnter = 0;  
	                // 每个队列里无限循环,分批拉取未消费的消息,直到拉取不到新消息为止  
	                SINGLE_MQ:while(cnter++ < 100){  
	                    long offset = consumer.fetchConsumeOffset(mq, false);  
	                    offset = offset < 0 ? 0:offset;  
	                    log.info("消费进度 offset: " + offset);  
	                    PullResult result = consumer.pull(mq, null, offset, 10);  
	                    log.info("接收到的消息集合 " + result);  
	                      
	                    switch(result.getPullStatus()){  
	                    case FOUND:  
	                        if(result.getMsgFoundList() != null){  
	                            int prSize = result.getMsgFoundList().size();  
	                            log.info("pullResult.getMsgFoundList().size()====" + prSize);  
	                            if(prSize != 0){  
	                                for(MessageExt me : result.getMsgFoundList()) {  
	                                    // 消费每条消息,如果消费失败,比如更新数据库失败,就重新再拉取一次消息  
	                                	log.info("pullResult.getMsgFoundList()消息体内容===="+ new String(me.getBody()));  
	                                }  
	                            }  
	                        }  
	                           // 获取下一个下标位置  
	                        offset = result.getNextBeginOffset();  
	                        // 消费完后，更新消费进度  
	                        consumer.updateConsumeOffset(mq, offset);  
	                        break;  
	                    case NO_MATCHED_MSG:  
	                    	log.info("没有匹配的消息");  
	                        break;  
	                    case NO_NEW_MSG:  
	                    	log.info("没有未消费的新消息");  
	                        // 拉取不到新消息,跳出SINGLE_MQ当前队列循环,开始下一队列循环  
	                        break SINGLE_MQ;  
	                    case OFFSET_ILLEGAL:  
	                    	log.info("下标错误");  
	                        break;  
	                    default:  
	                        break;  
	                    }  
	                }  
	            }
			} catch (Exception e) {
				// TODO: handle exception
				log.info(e.getMessage());
			}
			return Message.sucess();
		}
		
	}
	
}
