package com.mock.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mock.entity.IdCard;
import com.mock.entity.Message;
import com.mock.service.IdCardService;
import com.mock.vo.IdCardQueryVo;

@Controller
@RequestMapping(value="/IdCard")
public class IdCardController {
	private final static Logger log = LogManager.getLogger(IdCardController.class);
	@Autowired
	private IdCardService idCardService;
	
	/*
	 * 查询所有IdCard数据
	 */
	@RequestMapping(value="/lists")
	@ResponseBody
	public Message getIdCardPageInfo(IdCardQueryVo idCardQueryVo){
		
		try {
			int pn = idCardQueryVo.getPn();
			PageHelper.startPage(pn,15);
			
			List<IdCard> idCardlist=idCardService.getIdCardList(idCardQueryVo);
			PageInfo pageInfo = new PageInfo(idCardlist,5);
			
			return Message.sucess().add("pageInfo", pageInfo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
		return Message.fail();
	}
	
	/*
	 * 根据ID查询数据
	 */
	@RequestMapping(value="{id}")
	@ResponseBody
	public Message getA5Info(@PathVariable("id")int id){
		try {
			IdCard idCard = idCardService.getIdCard(id);
			return Message.sucess().add("idCard", idCard);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Message.fail();
	}
	
	/*
	 * 修改
	 */
	@RequestMapping(value="/update")
	@ResponseBody
	public Message updateIdCard(IdCard idCard){
		try {
			idCardService.updateIdCard(idCard);
			return Message.sucess();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Message.fail();
	}
	
	/*
	 * 删除
	 */	
	@RequestMapping(value="/del/{ids}")
	@ResponseBody
	/*@PathVariable("ids")  将ids绑定到delA5方法的入参，程序认为ids是一个参数，否则
	String[] str_idList = ids.split("-");会报错,*/
	public Message delIdCard(@PathVariable("ids")String ids){
		ArrayList<Integer> idList = new ArrayList<>();
		String[] str_idList = ids.split("-");
		try {
			if(ids.contains("-")){
				for(String id:str_idList){
					idList.add(Integer.parseInt(id));
				}
				log.info(idList.toString());
				idCardService.delBatchIdCard(idList);
				
				return Message.sucess();
			}else{
				idCardService.delIdCard(Integer.parseInt(ids));
				
				return Message.sucess();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Message.fail();
	}
	
	/*
	 * 新增
	 */	
	@RequestMapping(value="/add")
	@ResponseBody
	public Message AddA5(IdCard idCard){
		try {
			idCardService.saveIdCard(idCard);
			return Message.sucess();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Message.fail();
	}
}
