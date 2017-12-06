package com.mock.controller;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mock.dao.BookMapper;
import com.mock.entity.KafkaConfig;
import com.mock.vo.BookQueryVo;
import com.mock.constant.Constants;
import com.mock.constant.EnvEnum;





@Controller
@RequestMapping(value="/trade")
public class TestController {
	private final static Logger log = LogManager.getLogger(MockContrller.class);
	
	@Autowired
	private BookMapper bookMapper;
//	@Autowired
	private BookQueryVo bookQueryVo;
	@Autowired
	private KafkaConfig kafkaProducer;
	
	@RequestMapping(value="/111",method=RequestMethod.GET)
	public String test(){
		
		//String id=bookMapper.selectByPrimaryKey(4).getBookName();
		//String id=bookMapper.selectOneById(4).getBookType().getType_value();

		System.out.println("123");
		BookQueryVo bookQueryVo = new BookQueryVo();
//		bookQueryVo.setISBNNumber("111111");
//		bookQueryVo.setBookName("概率论");
//		bookQueryVo.setBook_type("6001");
//		String id = bookMapper.findBookList(bookQueryVo).get(1).getBookName();
//		System.out.println(id);
		bookQueryVo.setPn(1);
		log.info("1234");
		log.error("====");
		return "123";
	}
	@RequestMapping(value="/222",method=RequestMethod.GET)
	public String test2(){
		
		System.out.println(kafkaProducer.getAcks()+"=="+kafkaProducer.getBuffermemory()+kafkaProducer.getKeyserializer()+kafkaProducer.getValueserializer());
		System.out.println(Constants.KAFKA_PORT);
		System.out.println(EnvEnum.BetaA.getIp());
		 for(EnvEnum envEnum : EnvEnum.values()) {
			 System.out.println(envEnum+envEnum.getIp()+envEnum.getCode());
		}
		return "123";
	}
	@RequestMapping(value="/pay/tradeQuery",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String Lefan(){
		//String jsonstr="{\"code\":1000,\"message\":\"成功\",\"data\":{\"code\":\"0000\",\"msg\":\"请求成功\",\"sub_code\":null,\"sub_msg\":null,\"sign\":\"V/T0lSKrGER5d9pn06bLMziBoF0mAcMc8oFZzfJ5/lUhux9QH7X1hhbUPsdtBAo7GSl+eqHzU8nA\r\n02+uZXS05UiDJjLjZ/6hFHnzTK6AcLBdsdTDbnRUJPRvOmfm1IguywP5ZAkCcPO2SxiyvmwxtJn6\r\nL13sf9yW6CLxbHl9V0k=\r\n\",\"biz_content\":\"{\"alipay_store_id\":\"\",\"buyer_logon_id\":\"251***@qq.com\",\"buyer_pay_amount\":\"3089.00\",\"buyer_user_id\":\"2088002529770114\",\"discount_goods_detail\":\"\",\"fund_bill_list\":[{\"amount\":\"3089.00\",\"fundChannel\":\"PCREDIT\"}],\"industry_sepc_detail\":\"\",\"invoice_amount\":\"3089.00\",\"open_id\":\"\",\"out_trade_no\":\"53010201711210003-18\",\"point_amount\":\"0.00\",\"receipt_amount\":\"3089.00\",\"send_pay_date\":\"2017-11-21 11:43:41\",\"store_id\":\"\",\"store_name\":\"\",\"terminal_id\":\"\",\"total_amount\":\"3089.00\",\"trade_no\":\"2017112121001104115356764020\",\"trade_status\":\"TRADE_CLOSED\"}\"}}";
		String jsonstr="{\"code\":\"0000\",\"msg\":\"请求成功\",\"sign\":\"UrXnGWbP3gchqEbb8fZeyKtqI+6+o+gT7k28T6kjBkEMFzqh69XvK4Yeg1gNyMqqzY9WZs+qy0wO\r\nNC9AGySBhSmh1AauD3BLInBUbSC7M8Czyaol6+omjxMhIAza/1pQrEf8DKFpaJTd5PsEkCU6kvEH\r\nnhcI+LBE4XMj+XCrAmY=\r\n\",\"biz_content\":{\"total_amount\":\"413.40\",\"trade_no\":\"2017112121001104115357252011\",\"terminal_id\":\"\",\"open_id\":\"\",\"buyer_logon_id\":\"251***@qq.com\",\"store_id\":\"\",\"invoice_amount\":\"413.40\",\"out_trade_no\":\"53010201711210004-22\",\"trade_status\":\"TRADE_CLOSED\",\"point_amount\":\"0.00\",\"send_pay_date\":\"2017-11-21 16:44:39\",\"industry_sepc_detail\":\"\",\"buyer_user_id\":\"2088002529770114\",\"alipay_store_id\":\"\",\"buyer_pay_amount\":\"413.40\",\"discount_goods_detail\":\"\",\"receipt_amount\":\"413.40\",\"fund_bill_list\":[{\"amount\":\"413.40\",\"fundChannel\":\"PCREDIT\"}],\"store_name\":\"\"}}";
		return jsonstr;
	}
}
