<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% String path=request.getContextPath();%>
<!-- 引入标签库 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>柠檬A7</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%
    pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <link  rel="stylesheet" href="${APP_PATH}/resources/bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="${APP_PATH}/resources/js/jquery-2.0.0.min.js"></script>
	<script type="text/javascript" src="${APP_PATH}/resources/js/dropdown.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index">首页</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="book">图书管理 <span class="sr-only">(current)</span></a></li>
        <li><a href="bookType">图书类型管理</a></li>
        <li><a href="#">图书借阅</a></li>
        <li><a href="#">图书归还</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">报表统计<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">测试工具<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="">A7接口</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="A5">A5接口</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="nameIdCardAccountVerify">三要素</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="zhima">芝麻</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="kafka">kafka</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="rocketmq">rocketmq</a></li>
          </ul>
        </li>
      </ul>
<!--       <form class="navbar-form navbar-left"> -->
<!--         <div class="form-group"> -->
<!--           <input type="text" class="form-control" placeholder="Search"> -->
<!--         </div> -->
<!--         <button type="submit" class="btn btn-default">Submit</button> -->
<!--       </form> -->
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">welcome to back admin <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<!-- 图书添加的模态框-->
<div class="modal fade" id="a7AddModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">A7结果添加</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-2 control-label">priority</label>
						<div class="col-sm-10">
							<input type="text" name="priority" class="form-control"
								id="priority_add_input" placeholder="priority">
								<span  class="help-block"></span>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">errorCode</label>
						<div class="col-sm-10">
							<input type="text" name="errorCode" class="form-control"
								id="errorCode_add_input" placeholder="errorCode">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">errorMsg</label>
						<div class="col-sm-10">
							<input type="text" name="errorMsg" class="form-control"
								id="errorMsg_add_input" placeholder="errorMsg">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">checkResult</label>
						<div class="col-sm-10">
							<input type="text" name="checkResult" class="form-control"
								id="checkResult_add_input" placeholder="checkResult">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">creditScore</label>
						<div class="col-sm-10">
							<input type="text" name="creditScore" class="form-control"
								id="creditScore_add_input" placeholder="creditScore">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">timeout</label>
						<div class="col-sm-10">
							<input type="text" name="timeout" class="form-control"
								id="timeout_add_input" placeholder="timeout">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">appKey</label>
						<div class="col-sm-10">
							<input type="text" name="appKey" class="form-control"
								id="appKey_add_input" placeholder="appKey">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">orderId</label>
						<div class="col-sm-10">
							<input type="text" name="orderId" class="form-control"
								id="orderId_add_input" placeholder="orderId">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">insScore</label>
						<div class="col-sm-10">
							<input type="text" name="insScore" class="form-control"
								id="insScore_add_input" placeholder="insScore">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">m3Score</label>
						<div class="col-sm-10">
							<input type="text" name="m3Score" class="form-control"
								id="m3Score_add_input" placeholder="m3Score">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">reservationScore</label>
						<div class="col-sm-9">
							<input type="text" name="reservationScore" class="form-control"
								id="reservationScore_add_input" placeholder="reservationScore">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">m2Score</label>
						<div class="col-sm-10">
							<input type="text" name="m2Score" class="form-control"
								id="m2Score_add_input" placeholder="m2Score">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">riskName1</label>
						<div class="col-sm-10">
							<input type="text" name="riskName1" class="form-control"
								id="riskName1_add_input" placeholder="riskName1">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">riskName2</label>
						<div class="col-sm-10">
							<input type="text" name="riskName2" class="form-control"
								id="riskName2_add_input" placeholder="riskName2">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">times</label>
						<div class="col-sm-10">
							<input type="text" name="times" class="form-control"
								id="times_add_input" placeholder="times">
								<span  class="help-block"></span>
						</div>
					</div>
				</form>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" id="a7_save_btn">保存</button>
			</div>
		</div>
	</div>
</div>

<!-- 图书更新的模态框-->
<div class="modal fade" id="a7UpdateModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">A7数据修改</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-2 control-label">priority</label>
						<div class="col-sm-10">
							<input type="text" name="priority" class="form-control"
								id="priority_update_input" placeholder="priority">
								<span  class="help-block"></span>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">errorCode</label>
						<div class="col-sm-10">
							<input type="text" name="errorCode" class="form-control"
								id="errorCode_update_input" placeholder="errorCode">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">errorMsg</label>
						<div class="col-sm-10">
							<input type="text" name="errorMsg" class="form-control"
								id="errorMsg_update_input" placeholder="errorMsg">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">checkResult</label>
						<div class="col-sm-10">
							<input type="text" name="checkResult" class="form-control"
								id="checkResult_update_input" placeholder="checkResult">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">creditScore</label>
						<div class="col-sm-10">
							<input type="text" name="creditScore" class="form-control"
								id="creditScore_update_input" placeholder="creditScore">
								<span  class="help-block"></span>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label">timeout</label>
						<div class="col-sm-10">
							<input type="text" name="timeout" class="form-control"
								id="timeout_update_input" placeholder="timeout">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">appKey</label>
						<div class="col-sm-10">
							<input type="text" name="appKey" class="form-control"
								id="appKey_update_input" placeholder="appKey">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">orderId</label>
						<div class="col-sm-10">
							<input type="text" name="orderId" class="form-control"
								id="orderId_update_input" placeholder="orderId">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">insScore</label>
						<div class="col-sm-10">
							<input type="text" name="insScore" class="form-control"
								id="insScore_update_input" placeholder="insScore">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">m3Score</label>
						<div class="col-sm-10">
							<input type="text" name="m3Score" class="form-control"
								id="m3Score_update_input" placeholder="m3Score">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">reservationScore</label>
						<div class="col-sm-10">
							<input type="text" name="reservationScore" class="form-control"
								id="reservationScore_update_input" placeholder="reservationScore">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">m2Score</label>
						<div class="col-sm-10">
							<input type="text" name="m2Score" class="form-control"
								id="m2Score_update_input" placeholder="m2Score">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">riskName1</label>
						<div class="col-sm-10">
							<input type="text" name="riskName1" class="form-control"
								id="riskName1_update_input" placeholder="riskName1">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">riskName2</label>
						<div class="col-sm-10">
							<input type="text" name="riskName2" class="form-control"
								id="riskName2_update_input" placeholder="riskName2">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">times</label>
						<div class="col-sm-10">
							<input type="text" name="times" class="form-control"
								id="times_update_input" placeholder="times">
								<span  class="help-block"></span>
						</div>
					</div>					

				</form>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" id="book_update_btn">更新</button>
			</div>
		</div>
	</div>
</div>

<div class="containner">
	<!--标题-->
	<div class="row"></div>
	<div class="col-md-12">
		<h2>A7管理</h2>
	</div>
	<div class="row">
		<form class="form-horizontal">
			<div class="form-group col-md-3">
				<label class="col-sm-4  control-label">优先级:</label>
				<div class="col-sm-8">
					<input type="text" name="priority" class="form-control"
						id="priority_query_input" placeholder="priority">
						<span  class="help-block"></span>
				</div>
			</div>
			<div class="form-group col-md-3">
				<label class="col-sm-4 control-label">响应码:</label>
				<div class="col-sm-8">
					<input type="text" name="errorCode" class="form-control"
						id="errorCode_query_input" placeholder="errorCode">
						<span  class="help-block"></span>
				</div>
			</div>
			<div class="form-group col-md-3">
				<label class="col-sm-4 control-label">结果:</label>
				<div class="col-sm-8">
					<select class="form-control" name="checkResult" id="A7_type_query_select">
					<option selected="selected" disabled="disabled"  style='display: none' value=''></option> 
						<option value="0">建议审核</option>  
						<option value="1">建议通过</option>  
						<option value="2">建议拒绝</option>  					
					</select>
				</div>
			</div>
		</form>
		<div class="col-md-2 col-md-offset-10">
			<button class="btn btn-info glyphicon glyphicon-search" aria-label="Left Align" id="A7_query">查询</button>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<button class="btn btn-primary" id="a7_add_modal_btn">新增</button>
			<button class="btn btn-danger" id="a7_delete_all">删除</button>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<table class="table table-hover" id="a7_table">
				<colgroup>
				<col style="width:5%">
				<col style="width:5%">
				<col style="width:5%">
				<col style="width:5%">
				<col style="width:5%">
				<col style="width:5%">
				<col style="width:5%">
				<col style="width:5%">
				<col style="width:5%">
				<col style="width:5%">
				<col style="width:5%">
				<col style="width:5%">
				<col style="width:5%">
				<col style="width:5%">
				<col style="width:5%">
				<col style="width:5%">
				<col style="width:5%">
				<col style="width:5%">
				<col style="width:10%">
				</colgroup>
				<thead>
					<tr>
						<th>
							<input type="checkbox" id="check_all">
						</th> 
						<th>ID</th>
						<th>优先级</th>
						<th>响应码值</th>
						<th>响应说明</th>
						<th>得分结果</th>
						<th>信用得分</th>
						<th>超时时间</th>
						<th>渠道</th>
						<th>NM订单号</th>
						<th>INS得分</th>
						<th>M3得分</th>
						<th>无预约得分</th>
						<th>M2得分</th>
						<th>riskName1</th>
						<th>riskName2</th>
						<th>次数</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
	<!--分页信息-->
	<div class="row">
		<!--分页文字信息-->
		<div class="col-md-6" id="page_info_area"></div>
		<!--分页条信息-->
		<div class="col-md-2 col-md-offset-4" id="page_nav"></div>
	</div>
</div>
<script type="text/javascript">
	var totalRecord,currentPage;
	//1.在页面加载完成以后，直接去发送一个ajax请求,要到分页数据
	$(function() {
		//去首页
		to_page(1);
	});

	//查询下拉框
	/*$("#A7_type_query_select").click(function(){
		getBookType("#A7_type_query_select");
		$("#A7_type_query_select").empty()
		var obj = document.getElementById("A7_type_query_select");
		obj.options.add(new Option("text1","value"));
		obj.options.add(new Option("text2","value"));
	});*/
	//点击查询发送ajax请求
	$("#A7_query").click(function(){
		to_page(1);
	})
	function to_page(pn) {
		$.ajax({
			url : "${APP_PATH}/A7/lists",
			data : GetJsonData(pn),
			type : "GET",
			contentType : "application/json; charset=utf-8",
			dataType: "json",
			success : function(message) {
				//console.log(message);
				//1.解析并显示员工数据
				build_a7_table(message);
				//2.解析并显示分页信息
				build_page_info(message);
				//解析显示分页条数据
				build_page_nav(message);

			},
			error: function(message) {
				alert(message);
			}
		});
	}
	
	function GetJsonData(pn) {
		var jsonstr = {};
		jsonstr["pn"] = pn;
		var checkResult_query_input=$("#checkResult_query_input").val();
		var priority_query_input=$("#priority_query_input").val();
		var A7_query_input=$("#A7_type_query_select").val();
		//alert(checkResult_query_input+"-"+priority_query_input+"-"+A7_query_input);
		if(checkResult_query_input !== ''){
			jsonstr["errorCode"] = checkResult_query_input;
		}
		if(priority_query_input !== ''){
			jsonstr["priority"] = priority_query_input;
		}
		if(A7_query_input !== null){
			jsonstr["checkResult"] = A7_query_input;
		}
		
		return jsonstr;
	}
	//分页信息
	function build_page_info(message) {
		$("#page_info_area").empty();
		$("#page_info_area").append(
			"当前第"+message.extend.pageInfo.pageNum+"页,总"+message.extend.pageInfo.pages+"页,总"+message.extend.pageInfo.total+"条记录"
		);
		totalRecord=message.extend.pageInfo.total; //赋值为总记录数
		currentPage = message.extend.pageInfo.pageNum;
	}
	//分页条
	//http://v3.bootcss.com/components/#pagination
	function build_page_nav(message){
		$("#page_nav").empty();
		var ul=$("<ul></ul>").addClass("pagination");
		var firstPage=$("<li></li>").append(
		$("<a></a>").append("首页").attr("href","#")
		);
		//为元素添加点击翻页的事件
		firstPage.click(function(){
			to_page(1);
		})
		//上一页
		var previousPage=$("<li></li>").append(
		$("<a></a>").append("&laquo;")
		);
		//判断首页和上页是否可点击
		if(message.extend.pageInfo.hasPreviousPage == false){
			firstPage.addClass("disabled");
			previousPage.addClass("disabled");
		}
		previousPage.click(function(){
			to_page(message.extend.pageInfo.pageNum-1);
		})
		//下一页
		var nextpage=$("<li></li>").append($("<a></a>").append("&raquo;"));
		var lastpage=$("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
		if(message.extend.pageInfo.hasNextPage == false){
			nextpage.addClass("disabled");
			lastpage.addClass("disabled");
		}else{
			nextpage.click(function(){
				to_page(message.extend.pageInfo.pageNum + 1);
		});
			lastpage.click(function(){
				//alert(message.extend.pageInfo.pages);
				to_page(message.extend.pageInfo.pages);
			})
		}
		//将首页和上页li添加到ul中
		ul.append(firstPage).append(previousPage);
		//遍历页码并添加到ul中
		$.each(message.extend.pageInfo.navigatepageNums,function(index,item){
			var eachpage = $("<li></li>").append($("<a></a>").append(item));
			if(message.extend.pageInfo.pageNum == item){
				eachpage.addClass("active");
			}
			eachpage.click(function(){
				to_page(item);
			});
			ul.append(eachpage);
		})
		//将下页和末页li添加到ul中
		ul.append(nextpage).append(lastpage);
		//将ul添加到nav中
		var nav = $("<nav></nav>").append(ul);
		nav.appendTo("#page_nav");
		
	}

	function build_a7_table(message) {
		//清空table 表格
		$("#a7_table tbody").empty();
		var A7S = message.extend.pageInfo.list;
		$.each(A7S, function(index, item) {
			var checkBoxTd=$("<td><input type='checkbox' class='each_checkbox'/></td>");
			var id = $("<td></td>").append(item.id);
			var priority = $("<td></td>").append(item.priority);
			var errorCode = $("<td></td>").append(item.errorCode);
			var errorMsg = $("<td></td>").append(item.errorMsg);
			var checkResult = $("<td></td>").append(item.checkResult);
			var creditScore = $("<td></td>").append(item.creditScore);
			var timeout = $("<td></td>").append(item.timeout);
			var appKey = $("<td></td>").append(item.appKey);
			var orderId = $("<td></td>").append(item.orderId);
			var insScore = $("<td></td>").append(item.insScore);
			var m3Score = $("<td></td>").append(item.m3Score);
			var reservationScore = $("<td></td>").append(item.reservationScore);
			var m2Score = $("<td></td>").append(item.m2Score);
			var riskName1 = $("<td></td>").append(item.riskName1);
			var riskName2 = $("<td></td>").append(item.riskName2);
			var times = $("<td></td>").append(item.times);
			var editBtn = $("<button></button>").addClass(
					"btn btn-primary btn-sm edit_btn").append(
					$("<span></span>").addClass(
							"glyphicon glyph icon-pencil")).append("编辑");
			
			//为编辑按钮添加一个自定义的属性,来表示当前员工的id
			editBtn.attr("edit-id",item.id);
		 
			var delBtn = $("<button></button>").addClass(
					"btn btn-danger btn-sm delete_btn").append(
					$("<span></span>")
							.addClass("glyphicon glyphicon-trash")).append(
					"删除");
			
			//为删除按钮添加一个自定义的属性来表示当前员工的删除id
			delBtn.attr("del-id",item.id);
			var btnTd = $("<td></td>").append(editBtn).append(" ").append(
					delBtn);
			//append方法执行完成以后还是返回原来的元素
			$("<tr></tr>").append(checkBoxTd)
						.append(id)
						.append(priority)
						.append(errorCode)
						.append(errorMsg)
						.append(checkResult)
						.append(creditScore)
						.append(timeout)
						.append(appKey)
						.append(orderId)
						.append(insScore)
						.append(m3Score)
						.append(reservationScore)
						.append(m2Score)
						.append(riskName1)
						.append(riskName2)
						.append(times)
						.append(btnTd)
						.appendTo("#a7_table tbody")
		})
	}
	//单个删除
	$(document).on("click",".delete_btn",function(){
		 //1.弹出是否确认删除对话框
		 //var bookName = $(this).parents("tr").find("td:eq(3)").text();
		 var A7Id = $(this).attr("del-id");
		 //alert($(this).parents("tr").find("td:eq(1)").text());
		 if(confirm("确定删除当前记录吗?")){
			 //确认.发送ajax请求删除
			 $.ajax({
				 url:"${APP_PATH}/A7/del/"+A7Id,
				 type:"POST",
				 success:function(message){
					 alert(message.errorMsg);
					 //回到本页
					 to_page(currentPage);
					 //清除表单数据
				 }
			 })
		 }
	})
	//全选、全否
	$("#check_all").click(function(){
		//attr获取checked是undefined 
		//我们这些dom原生的属性:attr获取自定义属性的值,prop获取原生的值
		//alert($(this).prop("checked"));
		//$(".each_checkbox").prop("checked","checked");//这样只能选择一条
		$(".each_checkbox").prop("checked",$(this).prop("checked"));
	});
	//判断是否全选,按钮创建的时候绑定click事件，若果按钮已经创建则可使用$("#xxx").click(),最开始还没有each_checkbox按钮
	$(document).on("click",".each_checkbox",function(){
		var flag =$(".each_checkbox:checked").length==$(".each_checkbox").length;
		//alert(flag);
		$("#check_all").prop("checked",flag);
	});
	//全部删除
	$("#a7_delete_all").click(function(){
		var bookNames="";
		var ids="";
		$.each($(".each_checkbox:checked"),function(){
			bookNames=bookNames+($(this).parents("tr").find("td:eq(1)").text())+",";
			ids=ids+($(this).parents("tr").find("td:eq(1)").text())+"-";
		});
		bookNames=bookNames.substring(0,bookNames.length-1);
		ids=ids.substring(0,ids.length-1);
		if(ids==""){
			alert("您还没有选中记录");
			return false;
		};
		if(confirm("确认删除记录吗")){
			$.ajax({
			url:"${APP_PATH}/A7/del/"+ids,
			type:"POST",
			success:function(message){
				if(message.errorCode=200){
					alert("删除成功");
					to_page(currentPage);
				}else{
					alert(删除失败);
					to_page(currentPage);
				}
			}
		});
		}

	});
	//新增
	$("#a7_add_modal_btn").click(function(){
		//清除表单数据(表单完整重置(表单的数据，表单的样式))
		reset_form("#a7AddModal form");
		$("#a7AddModal form")[0].reset();
		//发送ajax请求，查出图书类型，显示在下拉列表中
		getBookType("#book_type_add_select");
		getBorrowType("#borrow_type_add_select");
		//弹出模态框
		$("#a7AddModal").modal({ //利用js创建模态框
			backdrop : "static"
		});
		
	})
	//清空表单样式以及内容
	function reset_form(ele){
		$(ele)[0].reset;
		//清空表单样式
		$(ele).find("*").removeClass("has-error has-success");
		$(ele).find(".help-block").text("");
	}
	function getBorrowType(ele){
		$(ele).empty();
		$.ajax({
			url:"${APP_PATH}/borrowTypes",
			type:"GET",
			success:function(message){
				$.each(message.extend.borrowTypes,function(){
					var optionEle = $("<option></option>").append(this.borrow_value).attr("value",this.borrow_type)
					optionEle.appendTo(ele)
				})
			}
		});
	}
	function getBookType(ele){
		//清空之前的下拉列表
		$(ele).empty();
		$.ajax({
			url:"${APP_PATH}/bookTypes",
			type:"GET",
			success:function(message){
				//线上图书类型在下拉列表中
				$.each(message.extend.bookTypes,function(){
					var optionEle = $("<option ></option>").append(this.type_value).attr("value",this.type_code);
					optionEle.appendTo(ele);
				})
			}
		});
	}
	//校验格式
	function validate_add_form(){
		
		var errorCode=$("#errorCode_add_input").val();
		var regerrorCode=/(^[0-9]{3}$)/;
		if(!regerrorCode.test(errorCode)){
			show_validate_msg("#errorCode_add_input","error","序列号只能是数字，如200、404等");
			return false;
		}else{
			show_validate_msg("#errorCode_add_input","success"," ");
		};
		var errorMsg=$("#errorMsg_add_input").val();
		if(errorMsg == null||errorMsg == undefined||errorMsg==''){
			show_validate_msg("#errorMsg_add_input","error","errorMsg不能为空");
			return false;
		}else{
			show_validate_msg("#errorMsg_add_input","success"," ");
		};
		var checkResult=$("#checkResult_add_input").val();
		if(checkResult == null||checkResult == undefined||checkResult==''){
			show_validate_msg("#checkResult_add_input","error","checkResult不能为空");
			return false;
		}else{
			show_validate_msg("#checkResult_add_input","success"," ");
		};
		var creditScore=$("#creditScore_add_input").val();
		if(creditScore == null||creditScore == undefined||creditScore==''){
			show_validate_msg("#creditScore_add_input","error","creditScore不能为空");
			return false;
		}else{
			show_validate_msg("#creditScore_add_input","success"," ");
		};
		var insScore=$("#insScore_add_input").val();
		if(insScore == null||insScore == undefined||insScore==''){
			show_validate_msg("#insScore_add_input","error","insScore不能为空");
			return false;
		}else{
			show_validate_msg("#insScore_add_input","success"," ");
		};
		var m3Score=$("#m3Score_add_input").val();
		if(m3Score == null||m3Score == undefined||m3Score==''){
			show_validate_msg("#m3Score_add_input","error","m3Score不能为空");
			return false;
		}else{
			show_validate_msg("#m3Score_add_input","success"," ");
		};
		var reservationScore=$("#reservationScore_add_input").val();
		if(reservationScore == null||reservationScore == undefined||reservationScore==''){
			show_validate_msg("#reservationScore_add_input","error","reservationScore不能为空");
			return false;
		}else{
			show_validate_msg("#reservationScore_add_input","success"," ");
		};
		var m2Score=$("#m2Score_add_input").val();
		if(m2Score == null||m2Score == undefined||m2Score==''){
			show_validate_msg("#m2Score_add_input","error","m2Score不能为空");
			return false;
		}else{
			show_validate_msg("#m2Score_add_input","success"," ");
			return true;
		};
	};
	//后台校验
	/*$("#priority_add_input").change(function(){
		var bookName=this.value;
		$.ajax({
			url:"${APP_PATH}/checkBookName",
			type:"POST",
			data:"bookName="+bookName,
			success:function(message){
				if(message.errorCode == 200){
					show_validate_msg("#priority_add_input","success","图书名称正常可用");
					$("#priority_add_input").attr("ajax_bookname","success");
				}else{
					show_validate_msg("#priority_add_input","error",message.extend.ajax_bookname_msg);
					$("#priority_add_input").attr("ajax_bookname","error");
				};
			}
		});
	})*/
	function show_validate_msg(ele,status,msg){
		//清除当前元素的校验状态
		$(ele).parent().removeClass("has-success has-error");
		$(ele).next("span").text(" ");
		if("success"==status){
			$(ele).parent().addClass("has-success");
			$(ele).next("span").text(msg);
			
		}else if("error"==status){
			$(ele).parent().addClass("has-error");
			$(ele).next("span").text(msg);
		}
	};
	//为保存按钮添加click时间
	$("#a7_save_btn").click(function(){
		//校验post数据
		if(!validate_add_form()){
			return false;
		}
		//ajax后台校验
		/*if(!$(this).attr("ajax_bookname") == "error"){
			return false;
		};*/
		//发送ajax请求
		$.ajax({
			url:"${APP_PATH}/A7/add",
			type:"POST",
			data:$("#a7AddModal form").serialize(),
			success:function(message){
				if(message.errorCode == 200){
					//关闭模态框
					$("#a7AddModal").modal("hide");
					to_page(99999);
				}else{
					alert(message.errorCode);
				}
			}
		});
	})
	//编辑
	$(document).on("click",".edit_btn",function(){
		//根据当前ID查询出A7信息，并展示
		getA7($(this).attr("edit-id"));
		//id传给模态框的更新按钮
		$("#book_update_btn").attr("update-id",$(this).attr("edit-id"));
		//弹出模态框
		$("#a7UpdateModal").modal({
			backdrop : "static"
		});
	})
	function getA7(id){
		$.ajax({
			url:"${APP_PATH}/A7/"+id,
			type:"GET",
			success:function(message){
				var a7 = message.extend.a7;
				$("#priority_update_input").val(a7.priority);
				$("#errorCode_update_input").val(a7.errorCode);
				$("#errorMsg_update_input").val(a7.errorMsg);
				$("#checkResult_update_input").val(a7.checkResult);
				$("#creditScore_update_input").val(a7.creditScore);
				$("#timeout_update_input").val(a7.timeout);
				$("#appKey_update_input").val(a7.appKey);
				$("#orderId_update_input").val(a7.orderId);
				$("#insScore_update_input").val(a7.insScore);
				$("#m3Score_update_input").val(a7.m3Score);
				$("#reservationScore_update_input").val(a7.reservationScore);
				$("#m2Score_update_input").val(a7.m2Score);
				$("#riskName1_update_input").val(a7.riskName1);
				$("#riskName2_update_input").val(a7.riskName2);
				$("#times_update_input").val(a7.times);
			}
		});
	}
	//更新
	$("#book_update_btn").click(function(){
		//校验post数据
		//提交请求
		var jsonData = $("#a7UpdateModal form").serializeArray();//json对象http://blog.csdn.net/csdnzhangtao5/article/details/52981541
		jsonData.push({"name":"id","value":$(this).attr("update-id")});
		//var strData = $("#a7UpdateModal form").serialize();//字符串也可以
		//strData=strData+"&"+"id="+$(this).attr("update-id");
		//可以在浏览器中直接输入$("#a7UpdateModal form").serialize();回车调试
		$.ajax({
			url:"${APP_PATH}/A7/update",
			type:"POST",
			//data:strData,
			data:jsonData,
			success:function(message){
				if(message.errorCode == 200){
					$("#a7UpdateModal").modal("hide");
					to_page(currentPage);
				}else{
					alert("更新失败");
				}
			}
		});
	})
</script>
<script type="text/javascript"
	src="${APP_PATH}/resources/bootstrap/js/bootstrap.js"></script>

</body>
</html>