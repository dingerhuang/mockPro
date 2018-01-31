# mockPro
整合之前的工程，引入mybatis和bootstrap实现mock结果可实时修改
主要功能：
1、模拟结果返回的实时增删改查
2、kafka发送消息
涉及知识点：
1、spring springmvc常用注解
2、前后端数据通过VO对象交互
3、mybatis引入及使用
4、properties配置文件在xml中引入及使用
5、web.xml中引入log4j
6、前端bootstrap简单知识点及简单的js、dom、ajax等操作
rocketmq备注：
使用mq消费者时，若改变topic需重启程序。

http://blog.csdn.net/liupeng_qwert/article/details/73555665
https://www.jianshu.com/p/453c6e7ff81c
（1）P2P模型

组成：消息队列(Queue)、发送者(Sender)、接收者(Receiver)

特征：每个消息只有一个消费者，一旦被消费，即从消息队列中删除（本地消费完之后向broker发送ACK），如果希望每个消息都被成功处理，则应该使用P2P模型

（2）Pub/Sub模型

组成：主题(Topic)、发布者(Publisher)、订阅者(Subscriber)
特征：如果希望发送的消息可以不做任何处理，或者被一个或多个消费者消费，则应该采用Pub/Sub模型

生产方式：
普通消息生产
顺序消息http://blog.csdn.net/www_wangzheguilai/article/details/76512372

消费方式：
长连接轮询方式拉取消息
主动pull模式拉取消息


重复消费


服务搭建（一）
wget https://github.com/alibaba/RocketMQ/releases/download/v3.2.6/alibaba-rocketmq-3.2.6.tar.gz
tar -zxvf alibaba-rocketmq-3.2.6.tar.gz
cd /home/rocketmq/bin
chmod +x mqadmin mqbroker mqfiltersrv mqshutdown  mqnamesrv
参数修改
vi runserver.sh
	JAVA_OPT="${JAVA_OPT} -server -Xms512m -Xmx512m -Xmn256m -XX:PermSize=128m -XX:MaxPermSize=320m"
启动
	nohup sh mqnamesrv &

	
配置broker
	创建borker配置文件
		mkdir ../conf/me-2m-2s-async/
		sh mqbroker -m > ../conf/me-2m-2s-async/broker.p
	修改brokerIP
		vi ../conf/me-2m-2s-async/broker.p
		显示指定为虚拟机的外网IP，不要用localhost和127.0.0.1，因为远程主机会根据brokerIP1指定的地址去访问broker
	启动broker
	nohup sh mqbroker -n localhost:9876 -c ../conf/me-2m-2s-async/broker.p &
	nohup sh mqbroker -n localhost:9876 autoCreateTopicEnable=true -c ../conf/me-2m-2s-async/broker.p &（autoCreateTopicEnable=true自动创建topic）
	topic CRUD 命令http://jameswxx.iteye.com/blog/2091971
	
	查看消息是否被消费
	sh mqadmin consumerProgress -g before_nplm_topic
关闭
sh mqshutdown broker
sh mqshutdown namesrv

安装、启动rocketmq-console
wget https://github.com/duomu/rocketmq-console/raw/master/rocketmq-console.war
war包丢到tomcat/webapps启动，访问http://ip:port/rocketmq-console

服务搭建（二）
搭建rocketmq-console-ng


activemq只需下载apache-activemq-5.14.1-bin.tar.gz直接启动即可
https://www.cnblogs.com/lyxy/p/5969116.html
