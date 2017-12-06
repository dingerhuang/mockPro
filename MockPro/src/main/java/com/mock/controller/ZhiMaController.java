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
import com.mock.entity.Message;
import com.mock.entity.Zhima;
import com.mock.service.ZhiMaService;
import com.mock.vo.A5QueryVo;
import com.mock.vo.ZhimaQueryVo;

@Controller
@RequestMapping(value="/Zhima")
public class ZhiMaController {

	@Autowired
	private ZhiMaService zhiMaService;
	
	/*
	 * 查询所有A5数据
	 */
	@RequestMapping(value="/lists")
	@ResponseBody
	public Message getZhimaPageInfo(ZhimaQueryVo zhimaQueryVo){
		
		try {
			int pn = zhimaQueryVo.getPn();
			PageHelper.startPage(pn,15);
			
			List<Zhima> zhimalist=zhiMaService.getZhimaList(zhimaQueryVo);
			PageInfo pageInfo = new PageInfo(zhimalist,5);
			
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
	public Message getZhimaInfo(@PathVariable("id")int id){
		try {
			Zhima zhima = zhiMaService.getZhima(id);
			return Message.sucess().add("zhima", zhima);
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
	public Message updateZhima(Zhima zhima){
		try {
			zhiMaService.updateZhima(zhima);
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
	public Message delZhima(@PathVariable("ids")String ids){
		ArrayList<Integer> idList = new ArrayList<>();
		String[] str_idList = ids.split("-");
		try {
			if(ids.contains("-")){
				for(String id:str_idList){
					idList.add(Integer.parseInt(id));
				}
				zhiMaService.delBatchZhima(idList);
				
				return Message.sucess();
			}else{
				zhiMaService.delZhima(Integer.parseInt(ids));
				
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
	public Message AddZhima(Zhima zhima){
		try {
			zhiMaService.saveZhima(zhima);
			return Message.sucess();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Message.fail();
	}
}
