package com.mock.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mock.dao.A5Mapper;
import com.mock.dao.A7Mapper;
import com.mock.dao.IdCardMapper;
import com.mock.dao.YSMapper;
import com.mock.dao.ZhimaMapper;
import com.mock.entity.A5;
import com.mock.entity.A7;
import com.mock.entity.IdCard;
import com.mock.entity.YS;
import com.mock.entity.Zhima;
import com.mock.util.CommonUtil;


/*
 * 整合mock工程和provider工程，并引入mybatis
 */
@Controller
public class MockContrller {
	private final static Logger log = LogManager.getLogger(MockContrller.class);

	@Autowired
	private A7Mapper a7Mapper;
	@Autowired
	private IdCardMapper idCardMapper;
	@Autowired
	private ZhimaMapper zhimaMapper;
	@Autowired
	private A5Mapper a5Mapper;
	@Autowired
	private YSMapper ysMapper;
	
	@RequestMapping(value="/A7",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	/*
	 * A7返回结果，返回t_mock_a7_result表中priority字段最大的值，返回值可在界面CRUD
	 */
	public String MockA7Result(String appKey,String orderIds,HttpServletRequest request) throws InterruptedException {
		//String ss=request.getParameter("appKey");
//		String remoteAddr = request.getHeader("X-FORWARDED-FOR");
//		remoteAddr = request.getRemoteAddr();
//		System.out.print(remoteAddr);
		JsonArray datas = new JsonArray();
		JsonObject A7 = new JsonObject();
		JsonObject scoreMap = new JsonObject();
		JsonObject data = new JsonObject();
		List<String> riskName = new LinkedList<String>();
		A7 a7=a7Mapper.getLatestResult();
		riskName.add(a7.getRiskName2());
		riskName.add(a7.getRiskName1());
		scoreMap.addProperty("lemond9344ab3daba36dc21951eed53c8e3b5", a7.getM3Score().toString());
		scoreMap.addProperty("lemonf68b31ea61e229b4a82bd4288d651745", a7.getInsScore().toString());
		scoreMap.addProperty("lemon8e1e15246b250f8142183bc084c9dd64", a7.getReservationScore().toString());
		scoreMap.addProperty("lemonaf01f94103976ba766284a926d9b30fd", a7.getM2Score().toString());
		A7.addProperty("errorCode", a7.getErrorCode().toString());
		A7.addProperty("errorMsg", a7.getErrorMsg());
		data.addProperty("checkResult", a7.getCheckResult().toString());
		data.addProperty("creditScore", a7.getCreditScore().toString());
		Gson gson = new Gson(); 
		String riskname = gson.toJson(riskName);
		data.addProperty("riskName",riskname);
		data.addProperty("appKey", appKey);
		data.addProperty("orderId", orderIds);
		data.add("scoreMap", scoreMap);
		datas.add(data);
		A7.add("data", datas);

		if (a7.getTimeout()==0){
			
		}else{
			Thread.sleep(a7.getTimeout());
		}
		
		return A7.toString();
	}
	/*
	 * 返回三要素认证结果，返回t_mock_idcard_result表中priority字段最大的值，返回值可在界面CRUD
	 */
	@RequestMapping(value="/nameIdCardAccountVerify",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String nameIdCardAccountVerify() throws InterruptedException{
		IdCard idcard = idCardMapper.getLatestResult();
		JsonObject jo = new JsonObject();
		JsonObject data = new JsonObject();
		int errorCode = idcard.getErrorCode();
		String errorMsg = idcard.getErrorMsg();
		String uid;
		if(idcard.getUid().isEmpty()){
			String timeSss=CommonUtil.getTimeSss();
			String randomStr=CommonUtil.getRandomString(15);
			uid = timeSss+randomStr;
		}else{
			uid = idcard.getUid();
		}
		jo.addProperty("errorCode", errorCode);
		jo.addProperty("errorMsg", errorMsg);
		jo.addProperty("uid", uid);
		String checkStatus = idcard.getCheckStatus();
		String message =idcard.getMessage();
		data.addProperty("checkStatus", checkStatus);
		data.addProperty("message", message);
		jo.add("data", data);
		if (idcard.getTimeout()==null){
		}else{
			Thread.sleep(idcard.getTimeout());
		}
		
		return jo.toString();
	}
	/*
	 * 返回二要素认证结果，返回t_mock_idcard_result表中priority字段最大的值，返回值可在界面CRUD
	 * 二要素和三要素的返回json数据格式一致，直接使用三要素的结果即可
	 */
	@RequestMapping(value="/idNameCheck",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String idNameCheck() throws InterruptedException{
		IdCard idcard = idCardMapper.getLatestResult();
		JsonObject jo = new JsonObject();
		JsonObject data = new JsonObject();
		int errorCode = idcard.getErrorCode();
		String errorMsg = idcard.getErrorMsg();
		String uid;
		if(idcard.getUid().isEmpty()){
			String timeSss=CommonUtil.getTimeSss();
			String randomStr=CommonUtil.getRandomString(15);
			uid = timeSss+randomStr;
		}else{
			uid = idcard.getUid();
		}
		jo.addProperty("errorCode", errorCode);
		jo.addProperty("errorMsg", errorMsg);
		jo.addProperty("uid", uid);
		String checkStatus = idcard.getCheckStatus();
		String message =idcard.getMessage();
		data.addProperty("checkStatus", checkStatus);
		data.addProperty("message", message);
		jo.add("data", data);
		if (idcard.getTimeout()==null){
		}else{
			Thread.sleep(idcard.getTimeout());
		}
		
		return jo.toString();
	}
	/*
	 * 短信接口，已写死
	 */
	@RequestMapping(value="/message",produces={"application/json;charset=UTF-8"})
	@ResponseBody
    public String SendMessage(){
        
		String jsonStr="{\"resultCode\" : 0,\"message\" : \"发送成功\"}";
		
		return jsonStr;

    }
	/*
	 * 芝麻信用，返回t_mock_zhima_result表中priority字段最大的值，返回值可在界面CRUD
	 */
	@RequestMapping(value="/zhima",produces={"application/json;charset=UTF-8"})
	@ResponseBody
    public String ZhiMa() throws InterruptedException{
        
		JsonObject zhimaScore = new JsonObject();
		JsonObject data = new JsonObject();
		Zhima zhima = zhimaMapper.getLatestResult();
		data.addProperty("result", zhima.getAuthorized());
		data.addProperty("authorized", zhima.getAuthorized());
		zhimaScore.add("data", data);
		zhimaScore.addProperty("errorCode", zhima.getErrorCode());
		zhimaScore.addProperty("errorMsg", zhima.getErrorMsg());
		String uid;
		if (zhima.getUid() == null||zhima.getUid().isEmpty()) {
			//时间戳
			//long uid=System.currentTimeMillis();
			String timeSss=CommonUtil.getTimeSss();
			String randomStr=CommonUtil.getRandomString(15);
			uid = timeSss+randomStr;
		} else {
			uid = zhima.getUid();
		}
		zhimaScore.addProperty("uid", uid);
		//
		if (zhima.getTimeout() == null) {
		} else {
			Thread.sleep(zhima.getTimeout());
		}
		
		return zhimaScore.toString();
    }
	/*
	 * A6接口只需返回成功直接写死
	 */
    @RequestMapping(value="/getFKReportResult",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String a6(String appKey,String orderId){
    	JsonObject jo = new JsonObject();
    	jo.addProperty("errorCode", 200);
    	jo.addProperty("errorMsg", "success");
    	jo.addProperty("data", "http://www.baidu.com");
    	
    	return jo.toString();
    }
    /*
     * A5接口，返回t_mock_a5_result表中priority字段最大的值，返回值可在界面CRUD
     */
    @RequestMapping(value="/submitApplicationData",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String submitApplicationData(String loanDataJson) throws InterruptedException{
    	JsonObject jo = new JsonObject();
    	A5 a5 = a5Mapper.getLatestResult(); 
    	jo.addProperty("errorCode", a5.getErrorCode());
    	jo.addProperty("errorMsg", a5.getErrorMsg());
    	jo.addProperty("data", a5.getData());
    	if(a5.getTimeout()==null){
    		
    	}else{
    		Thread.sleep(a5.getTimeout());
    	}
    	
		return jo.toString();
	}
    //信用卡芝麻分融合接口
    @RequestMapping(value="/receiveParams",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String receiveParams(HttpServletRequest request) throws InterruptedException{

    	JsonObject jo = new JsonObject();
    	jo.addProperty("errorCode", 200);
    	jo.addProperty("errorMsg", "请求成功");
    	Calendar cal = Calendar.getInstance(); 
		Date date = cal.getTime();
    	String data=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(date);
		String str=CommonUtil.getRandomString(13);
		data =data+str;
		jo.addProperty("data", data);
		return jo.toString();
	}
    
    /*
     * 银盛返回结果
     */
    @RequestMapping(value="/ys",produces={"application/xml;charset=UTF-8"})
	@ResponseBody
	public YS YinSheng() throws InterruptedException{
    	YS ys = ysMapper.getLatestResult();
    	//返回结果不需要id,结果不影响
    	ys.setId(null);
    	CommonUtil.thinkTime(ys.getTimeout());
    	//debug日志需要在log4j.properties中进行配置
    	log.info("success");

		return ys;
	}
    /*
     *公众号-我得账单，获取账单数据
     */
    @RequestMapping(value="/weixinCust/getWeixinCustRepayInfo",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public String getWeixinCustRepayInfo(){
    	String jsonData="{\"code\": 1,\"data\": [{\"id\": null,\"loanId\": \"2c90826396a31add0196a40ea8ee00a6\",\"loanNo\": \"11000201803130002\",\"certNo\": \"510681198911250615\",\"custName\": \"测试\",\"loanAmount\": 3000.00,\"loanInstalments\": 10,\"monthRepayAmount\": 330.00,\"firstRepayDate\": \"20180413\",\"lastRepayDate\": null,\"monthRepayDate\": \"13\",\"contractStatus\": \"3\",\"phaseNumber\": 2,\"dueDate\": 1522598400000,\"repayDate\": null,\"repayStatus\": \"0\",\"plannedTotal\": 330.00,\"indeedTotal\": 0.00,\"plannedCapital\": 289.31,\"reduceTotal\": 0.00,\"indeedCapital\": 0.00,\"plannedForfeit\": 0.00,\"indeedForfeit\": 0.00,\"updateTime\": null,\"busiType\": \"0\",\"endPhaseNumber\": 2,\"busiId\": \"31079726\",\"channel\": \"002\",\"balance\": 0.00,\"repayType\": null,\"overdueLevel\": \"0\"}, {\"id\": null,\"loanId\": \"2c90826396a31add0196a40ea8ee00a6\",\"loanNo\": \"11000201803130002\",\"certNo\": \"510681198911250615\",\"custName\": \"测试\",\"loanAmount\": 3000.00,\"loanInstalments\": 10,\"monthRepayAmount\": 330.00,\"firstRepayDate\": \"20180413\",\"lastRepayDate\": null,\"monthRepayDate\": \"13\",\"contractStatus\": \"3\",\"phaseNumber\": 1,\"dueDate\": 1520870400000,\"repayDate\": null,\"repayStatus\": \"3\",\"plannedTotal\": 350.00,\"indeedTotal\": 0.00,\"plannedCapital\": 286.36,\"reduceTotal\": 0.00,\"indeedCapital\": 0.00,\"plannedForfeit\": 20.00,\"indeedForfeit\": 0.00,\"updateTime\": null,\"busiType\": \"3\",\"endPhaseNumber\": 1,\"busiId\": \"ff8080816218064401621e3afde403ff\",\"channel\": \"002\",\"balance\": 0.00,\"repayType\": null,\"overdueLevel\": \"1\"}]}";
    	return jsonData;
    }
    /*
     *公众号-我得账单，立即还款
     */
    @RequestMapping(value="/weixinCust/getWeixinCustRepayStatus",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public	String getWeixinCustRepayStatus(){
    	String jsonData = "{\"code\" : 1,\"data\" : {\"code\":\"0000\",\"msg\":\"接口调用成功\"}}";
    	return jsonData;
    }
    /*
     *公众号-我得账单，绑定银行卡
     */
    @RequestMapping(value="/weixinCust/getWeiXinCustNewBankCardInfo",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public	String getWeiXinCustNewBankCardInfo(){
    	String jsonData = "{\"data\" : {\"retCode\":0,\"cardTypeName\":\"金穗通宝卡(银联卡)\",\"bankName\":\"中国农业银行\",\"cardType\":0,\"bankCode\":\"103\"},\"code\":1}";
    	return jsonData;
    }
    /*
     *公众号-我得账单，绑定银行卡-填写手机号码（预支付）
     */
    @RequestMapping(value="/weixinCust/doWeixinCustPrepay",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public	String doWeixinCustPrepay(){
    	String jsonData = "{\"data\" : {\"thirdErrorDesc\":\"等待用户回填验证码\",\"tradeStatus\":2,\"payNo\":\"20170418113700e4b042a858f437ed\",\"errorDesc\":null,\"thirdErrorCode\":\"2002\",\"errorCode\":0,\"attachOne\":\"337196122563665920\"},\"code\" : 1}";
    	
    	return jsonData;
    }
    /*
     *公众号-我得账单，绑定银行卡-填写手机号码（支付）
     */
    @RequestMapping(value="/weixinCust/doWeiXinCustTrade",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public	String doWeiXinCustTrade(){
    	String jsonData = "{\"data\":{\"payAmount\":1238.00,\"thirdErrorDesc\":\"\",\"tradeStatus\":2,\"payNo\":\"20170418113700e4b042a858f437ed\",\"errorDesc\":null,\"thirdErrorCode\":\"\",\"errorCode\":0},\"code\" :1}";
    	
    	return jsonData;
    }
}
