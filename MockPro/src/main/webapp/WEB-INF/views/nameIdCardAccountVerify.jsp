<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% String path=request.getContextPath();%>
<!-- 引入标签库 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>柠檬三要素</title>
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
            <li><a href="A7">A7接口</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="A5">A5接口</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="">三要素</a></li>
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
<div class="modal fade" id="idcardAddModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">IdCard结果添加</h4>
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
						<label class="col-sm-2 control-label">uid</label>
						<div class="col-sm-10">
							<input type="text" name="uid" class="form-control"
								id="uid_add_input" placeholder="uid">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">checkStatus</label>
						<div class="col-sm-10">
							<input type="text" name="checkStatus" class="form-control"
								id="checkStatus_add_input" placeholder="checkStatus">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">message</label>
						<div class="col-sm-10">
							<input type="text" name="message" class="form-control"
								id="message_add_input" placeholder="message">
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
				<button type="button" class="btn btn-primary" id="idcard_save_btn">保存</button>
			</div>
		</div>
	</div>
</div>

<!-- 图书更新的模态框-->
<div class="modal fade" id="idcardUpdateModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">IdCard数据修改</h4>
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
						<label class="col-sm-2 control-label">uid</label>
						<div class="col-sm-10">
							<input type="text" name="uid" class="form-control"
								id="uid_update_input" placeholder="uid">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">checkStatus</label>
						<div class="col-sm-10">
							<input type="text" name="checkStatus" class="form-control"
								id="checkStatus_update_input" placeholder="checkStatus">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">message</label>
						<div class="col-sm-10">
							<input type="text" name="message" class="form-control"
								id="message_update_input" placeholder="message">
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
				<button type="button" class="btn btn-primary" id="idcard_update_btn">更新</button>
			</div>
		</div>
	</div>
</div>

<div class="containner">
	<!--标题-->
	<div class="row"></div>
	<div class="col-md-12">
		<h2>NM三要素管理</h2>
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
		</form>
		<div class="col-md-2 col-md-offset-10">
			<button class="btn btn-info glyphicon glyphicon-search" aria-label="Left Align" id="IdCard_query">查询</button>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<button class="btn btn-primary" id="idcard_add_modal_btn">新增</button>
			<button class="btn btn-danger" id="idcard_delete_all">删除</button>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<table class="table table-hover" id="idcard_table">
				<colgroup>
				<col style="width:5%">
				<col style="width:5%">
				<col style="width:10%">
				<col style="width:10%">
				<col style="width:10%">
				<col style="width:10%">
				<col style="width:10%">
				<col style="width:10%">
				<col style="width:10%">
				<col style="width:10%">
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
						<th>UUID</th>
						<th>checkStatus</th>
						<th>message</th>
						<th>超时时间</th>
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
	$("#IdCard_query").click(function(){
		to_page(1);
	})
	function to_page(pn) {
		$.ajax({
			url : "${APP_PATH}/IdCard/lists",
			data : GetJsonData(pn),
			type : "GET",
			contentType : "application/json; charset=utf-8",
			dataType: "json",
			success : function(message) {
				//console.log(message);
				//1.解析并显示员工数据
				build_idcard_table(message);
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
		var priority_query_input=$("#priority_query_input").val();
		var errorCode_query_input=$("#errorCode_query_input").val();
		//alert(checkResult_query_input+"-"+priority_query_input+"-"+IdCard_query_input);
		if(priority_query_input !== ''){
			jsonstr["priority"] = priority_query_input;
		}
		if(errorCode_query_input !== ''){
			jsonstr["errorCode"] = errorCode_query_input;
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

	function build_idcard_table(message) {
		//清空table 表格
		$("#idcard_table tbody").empty();
		var IdCardS = message.extend.pageInfo.list;
		$.each(IdCardS, function(index, item) {
			var checkBoxTd=$("<td><input type='checkbox' class='each_checkbox'/></td>");
			var id = $("<td></td>").append(item.id);
			var priority = $("<td></td>").append(item.priority);
			var errorCode = $("<td></td>").append(item.errorCode);
			var errorMsg = $("<td></td>").append(item.errorMsg);
			var uid = $("<td></td>").append(item.uid);
			var checkStatus = $("<td></td>").append(item.checkStatus);
			var message = $("<td></td>").append(item.message);
			var timeout = $("<td></td>").append(item.timeout);
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
						.append(uid)
						.append(checkStatus)
						.append(message)
						.append(timeout)
						.append(times)
						.append(btnTd)
						.appendTo("#idcard_table tbody")
		})
	}
	//单个删除
	$(document).on("click",".delete_btn",function(){
		 //1.弹出是否确认删除对话框
		 //var bookName = $(this).parents("tr").find("td:eq(3)").text();
		 var IdCardId = $(this).attr("del-id");
		 //alert($(this).parents("tr").find("td:eq(1)").text());
		 if(confirm("确定删除当前记录吗?")){
			 //确认.发送ajax请求删除
			 $.ajax({
				 url:"${APP_PATH}/IdCard/del/"+IdCardId,
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
	$("#idcard_delete_all").click(function(){
		var ids="";
		$.each($(".each_checkbox:checked"),function(){
			ids=ids+($(this).parents("tr").find("td:eq(1)").text())+"-";
		});
		ids=ids.substring(0,ids.length-1);
		if(ids==""){
			alert("您还没有选中记录");
			return false;
		};
		if(confirm("确认删除记录吗")){
			$.ajax({
			url:"${APP_PATH}/IdCard/del/"+ids,
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
	$("#idcard_add_modal_btn").click(function(){
		//清除表单数据(表单完整重置(表单的数据，表单的样式))
		reset_form("#idcardAddModal form");
		$("#idcardAddModal form")[0].reset();
		//弹出模态框
		$("#idcardAddModal").modal({ //利用js创建模态框
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
	
	//校验格式
	function validate_add_form(){
		
		var errorCode=$("#errorCode_add_input").val();
		var regerrorCode=/(^[0-9]{3}$)/;
		if(!regerrorCode.test(errorCode)){
			show_validate_msg("#errorCode_add_input","error","序列号只能是数字，如200、404等");
			return false;
		}else{
			show_validate_msg("#errorCode_add_input","success"," ");
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
	$("#idcard_save_btn").click(function(){
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
			url:"${APP_PATH}/IdCard/add",
			type:"POST",
			data:$("#idcardAddModal form").serialize(),
			success:function(message){
				if(message.errorCode == 200){
					//关闭模态框
					$("#idcardAddModal").modal("hide");
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
		getA5($(this).attr("edit-id"));
		//id传给模态框的更新按钮
		$("#idcard_update_btn").attr("update-id",$(this).attr("edit-id"));
		//弹出模态框
		$("#idcardUpdateModal").modal({
			backdrop : "static"
		});
	})
	function getA5(id){
		$.ajax({
			url:"${APP_PATH}/IdCard/"+id,
			type:"GET",
			success:function(message){
				var idCard = message.extend.idCard;
				$("#priority_update_input").val(idCard.priority);
				$("#errorCode_update_input").val(idCard.errorCode);
				$("#errorMsg_update_input").val(idCard.errorMsg);
				$("#uid_update_input").val(idCard.uid);
				$("#checkStatus_update_input").val(idCard.checkStatus);
				$("#message_update_input").val(idCard.message);
				$("#timeout_update_input").val(idCard.timeout);
				$("#times_update_input").val(idCard.times);
			}
		});
	}
	//更新
	$("#idcard_update_btn").click(function(){
		//校验post数据
		//提交请求
		var jsonData = $("#idcardUpdateModal form").serializeArray();//json对象http://blog.csdn.net/csdnzhangtao5/article/details/52981541
		jsonData.push({"name":"id","value":$(this).attr("update-id")});
		//var strData = $("#idcardUpdateModal form").serialize();//字符串也可以
		//strData=strData+"&"+"id="+$(this).attr("update-id");
		//可以在浏览器中直接输入$("#idcardUpdateModal form").serialize();回车调试
		$.ajax({
			url:"${APP_PATH}/IdCard/update",
			type:"POST",
			//data:strData,
			data:jsonData,
			success:function(message){
				if(message.errorCode == 200){
					$("#idcardUpdateModal").modal("hide");
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