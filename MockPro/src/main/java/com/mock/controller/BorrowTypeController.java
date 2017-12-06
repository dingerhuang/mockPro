package com.mock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mock.entity.BorrowType;
import com.mock.entity.Message;
import com.mock.service.BorrowTypeService;

@Controller
public class BorrowTypeController {

	@Autowired
	private BorrowTypeService borrowTypeService;
	
	@RequestMapping(value="/borrowTypes")
	@ResponseBody
	public Message getBorrowTypes(){
		List<BorrowType> borrowTypes = borrowTypeService.getBorrowTypes();
		return Message.sucess().add("borrowTypes", borrowTypes);
	}
}
