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
import com.mock.entity.A7;
import com.mock.entity.Book;
import com.mock.entity.Message;
import com.mock.service.A7Service;
import com.mock.vo.A7QueryVo;

@Controller
@RequestMapping(value="/A7")
public class A7Controller {
	
	@Autowired
	private A7Service a7Service;

	/*
	 * 查询所有A7数据
	 */
	@RequestMapping(value="/lists")
	@ResponseBody
	public Message getA7PageInfo(A7QueryVo a7QueryVo){
		
		try {
			int pn = a7QueryVo.getPn();
			PageHelper.startPage(pn,15);
			
			List<A7> a7list=a7Service.getA7List(a7QueryVo);
			PageInfo pageInfo = new PageInfo(a7list,5);
			
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
	public Message getA7Info(@PathVariable("id")int id){
		try {
			A7 a7 = a7Service.getA7(id);
			return Message.sucess().add("a7", a7);
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
	public Message updateA7(A7 a7){
		try {
			a7Service.updateA7(a7);
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
	/*@PathVariable("ids")  将ids绑定到delA7方法的入参，程序认为ids是一个参数，否则
	String[] str_idList = ids.split("-");会报错,*/
	public Message delA7(@PathVariable("ids")String ids){
		ArrayList<Integer> idList = new ArrayList<>();
		String[] str_idList = ids.split("-");
		try {
			if(ids.contains("-")){
				for(String id:str_idList){
					idList.add(Integer.parseInt(id));
				}
				System.out.println(idList.toString());
				a7Service.delBatchA7(idList);
				
				return Message.sucess();
			}else{
				a7Service.delA7(Integer.parseInt(ids));
				
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
	public Message AddA7(A7 a7){
		try {
			a7Service.saveA7(a7);
			return Message.sucess();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Message.fail();
	}
}
