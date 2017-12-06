package com.mock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mock.entity.BookType;
import com.mock.entity.Message;
import com.mock.service.BookTypeService;

@Controller
public class BookTypeController {

	@Autowired
	BookTypeService bookTypeService;
	
	/*
	 * 分页信息
	 */
	
	/*
	 * 获取图书类型
	 */
	@RequestMapping(value="/bookTypes")
	@ResponseBody
	public Message getBookTypes(){
		List<BookType> bookTypes = bookTypeService.getBookTypes();
		return Message.sucess().add("bookTypes", bookTypes);
	}
}
