package com.mock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mock.entity.A5;
import com.mock.entity.A7;
import com.mock.entity.Message;
import com.mock.service.A5Service;
import com.mock.vo.A5QueryVo;
import com.mock.vo.A7QueryVo;

@Controller
@RequestMapping(value="/A5")
public class A5Controller {

	@Autowired
	private A5Service a5Service;
	
	/*
	 * 查询所有A5数据
	 */
	@RequestMapping(value="/lists")
	@ResponseBody
	public Message getA5PageInfo(A5QueryVo a5QueryVo){
		
		try {
			int pn = a5QueryVo.getPn();
			PageHelper.startPage(pn,15);
			
			List<A5> a5list=a5Service.getA5List(a5QueryVo);
			PageInfo pageInfo = new PageInfo(a5list,5);
			
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
			A5 a5 = a5Service.getA5(id);
			return Message.sucess().add("a5", a5);
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
	public Message updateA5(A5 a5){
		try {
			a5Service.updateA5(a5);
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
	public Message delA5(@PathVariable("ids")String ids){
		ArrayList<Integer> idList = new ArrayList<>();
		String[] str_idList = ids.split("-");
		try {
			if(ids.contains("-")){
				for(String id:str_idList){
					idList.add(Integer.parseInt(id));
				}
				System.out.println(idList.toString());
				a5Service.delBatchA5(idList);
				
				return Message.sucess();
			}else{
				a5Service.delA5(Integer.parseInt(ids));
				
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
	public Message AddA5(A5 a5){
		try {
			a5Service.saveA5(a5);
			return Message.sucess();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Message.fail();
	}
}
