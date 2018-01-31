package com.mock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/manage")
public class SystemContrller {
	
	/*
	 * 首页
	 */
	@RequestMapping(value="/index")
	public String index(){
		return "redirect:/";
	}

	/*
	 * 图书管理
	 */
	@RequestMapping(value="/book")
	public String ManageBook(){
		return "book";
	}
	
	/*
	 * 图书类型管理
	 */
	@RequestMapping(value="/bookType")
	public String ManageBookType(){
		return "bookType";
	}
	
	/*
	 * 图书借阅
	 */
	@RequestMapping(value="/bookBorrow")
	public String ManageBookBorrow(){
		return "bookBorrow";
	}
	
	/*
	 * 图书归还
	 */
	@RequestMapping(value="/bookReturn")
	public String ManageBookReturn(){
		return "bookReturn";
	}
	
	/*
	 * 报表统计
	 */
	@RequestMapping(value="/report")
	public String ManageBookReport(){
		return "bookReport";
	}
	
	/*
	 * 测试工具
	 */
	@RequestMapping(value="/testTools")
	public String ManageTestTools(){
		return "testTools";
	}
	
	/*
	 * kafka
	 */
	@RequestMapping(value="/kafka")
	public String ManageKafka(){
		return "kafka";
	}
	
	/*
	 * A7
	 */
	@RequestMapping(value="/A7")
	public String ManageA7(){
		return "A7";
	}
	/*
	 * A5
	 */
	@RequestMapping(value="/A5")
	public String ManageA5(){
		return "A5";
	}
	/*
	 * nameIdCardAccountVerify三要素
	 */
	@RequestMapping(value="/nameIdCardAccountVerify")
	public String ManageNameIdCardAccountVerify(){
		return "nameIdCardAccountVerify";
	}
	/*
	 * zhima
	 */
	@RequestMapping(value="/zhima")
	public String Managezhima(){
		return "zhima";
	}
	/*
	 * rocketmq
	 */
	@RequestMapping(value="/rocketmq")
	public String Managehttp(){
		return "rocketmq";
	}
	
	
	
}
