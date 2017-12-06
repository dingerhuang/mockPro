package com.mock.util;

import org.apache.log4j.Logger;

public class Logging {

	static Logger logger = Logger.getLogger(Logging.class);
	public static void logTest(){
		logger.trace("trace级别的日志输出");  
		logger.info("info级别的日志输出");  
		logger.debug("debug级别的日志输出");  
		logger.warn("warn级别的日志输出");  
		logger.error("error级别的日志输出");  
		logger.fatal("fatal级别的日志输出");
	}
	
	public static void info(String message){
		logger.info(message);
	}
	public static void debug(String message){
		logger.info(message);
	}
	public static void error(String message){
		logger.info(message);
	}
}
