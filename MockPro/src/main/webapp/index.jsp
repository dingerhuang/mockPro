<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% String path=request.getContextPath();%>
<!-- 引入标签库 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>首页</title>
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
      <a class="navbar-brand" href="manage/index">首页</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="manage/book">图书管理 <span class="sr-only">(current)</span></a></li>
        <li><a href="manage/bookType">图书类型管理</a></li>
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
            <li><a href="manage/A7">A7接口</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="manage/A5">A5接口</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="manage/nameIdCardAccountVerify">三要素</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="manage/zhima">芝麻</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="manage/kafka">kafka</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="manage/rocketmq">rocketmq</a></li>
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
<div class="modal fade" id="bookAddModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">图书添加</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-2 control-label">bookName</label>
						<div class="col-sm-10">
							<input type="text" name="bookName" class="form-control"
								id="bookName_add_input" placeholder="bookName">
								<span  class="help-block"></span>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">ISBNNumber</label>
						<div class="col-sm-10">
							<input type="text" name="ISBNNumber" class="form-control"
								id="ISBNNumber_add_input" placeholder="ISBNNumber">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">price</label>
						<div class="col-sm-10">
							<input type="text" name="price" class="form-control"
								id="price_add_input" placeholder="price">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">press</label>
						<div class="col-sm-10">
							<input type="text" name="press" class="form-control"
								id="press_add_input" placeholder="press">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">writer</label>
						<div class="col-sm-10">
							<input type="text" name="writer" class="form-control"
								id="writer_add_input" placeholder="writer">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">book_type</label>
						<div class="col-sm-4">
							<select class="form-control" name="book_type" id="book_type_add_select">
							</select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">borrow_type</label>
						<div class="col-sm-4"> 
							<select class="form-control" name="borrow_type" id="borrow_type_add_select">

							</select>
						</div>
					</div>

				</form>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" id="book_save_btn">保存</button>
			</div>
		</div>
	</div>
</div>

<!-- 图书更新的模态框-->
<div class="modal fade" id="bookUpdateModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">图书修改</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-2 control-label">bookName</label>
						<div class="col-sm-10">
							<p class="form-control-static" id="bookName_update_static"></p>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">ISBNNumber</label>
						<div class="col-sm-10">
							<input type="text" name="ISBNNumber" class="form-control"
								id="ISBNNumber_update_input" placeholder="ISBNNumber">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">price</label>
						<div class="col-sm-10">
							<input type="text" name="price" class="form-control"
								id="price_update_input" placeholder="price">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">press</label>
						<div class="col-sm-10">
							<input type="text" name="press" class="form-control"
								id="press_update_input" placeholder="press">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">writer</label>
						<div class="col-sm-10">
							<input type="text" name="writer" class="form-control"
								id="writer_update_input" placeholder="writer">
								<span  class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">book_type</label>
						<div class="col-sm-4">
							<select class="form-control" name="book_type" id="book_type_update_select">
							</select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">borrow_type</label>
						<div class="col-sm-4"> 
							<select class="form-control" name="borrow_type" id="borrow_type_update_select">

							</select>
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
		<h2>图书管理</h2>
	</div>
	<div class="row">
		<form class="form-horizontal">
			<div class="form-group col-md-3">
				<label class="col-sm-4  control-label">序列号:</label>
				<div class="col-sm-8">
					<input type="text" name="ISBNNumber" class="form-control"
						id="ISBNNumber_query_input" placeholder="ISBNNumber">
						<span  class="help-block"></span>
				</div>
			</div>
			<div class="form-group col-md-3">
				<label class="col-sm-4 control-label">图书名称:</label>
				<div class="col-sm-8">
					<input type="text" name="bookName" class="form-control"
						id="bookName_query_input" placeholder="bookName">
						<span  class="help-block"></span>
				</div>
			</div>
			<div class="form-group col-md-3">
				<label class="col-sm-4 control-label">图书类型:</label>
				<div class="col-sm-8">
					<select class="form-control" name="book_type" id="book_type_query_select">
					<option selected="selected" disabled="disabled"  style='display: none' value=''></option> 
						<option value="6001">科技</option>  
						<option value="6002">文学</option>  
						<option value="6003">政治</option>  
						<option value="6004">法学</option>
						<option value="6005">历史</option> 	
						<option value="6006">经济</option> 						
					</select>
				</div>
			</div>
		</form>
		<div class="col-md-2 col-md-offset-10">
			<button class="btn btn-info glyphicon glyphicon-search" aria-label="Left Align" id="book_query">查询</button>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<button class="btn btn-primary" id="book_add_modal_btn">新增</button>
			<button class="btn btn-danger" id="book_delete_all">删除</button>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<table class="table table-hover table-bordered table-striped text-nowrap" id="books_table">
				<colgroup>
				<col style="width:10%">
				<col style="width:10%">
				<col style="width:10%">
				<col style="width:15%">
				<col style="width:10%">
				<col style="width:15%">
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
						<th>序列号</th>
						<th>图书名称</th>
						<th>价格</th>
						<th>出版社</th>
						<th>作者</th>
						<th>图书类型</th>
						<th>借阅类型</th>
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
	/*$("#book_type_query_select").click(function(){
		getBookType("#book_type_query_select");
		$("#book_type_query_select").empty()
		var obj = document.getElementById("book_type_query_select");
		obj.options.add(new Option("text1","value"));
		obj.options.add(new Option("text2","value"));
	});*/
	//点击查询发送ajax请求
	$("#book_query").click(function(){
		to_page(1);
	})
	function to_page(pn) {
		$.ajax({
			url : "${APP_PATH}/books",
			data : GetJsonData(pn),
			type : "GET",
			contentType : "application/json; charset=utf-8",
			dataType: "json",
			success : function(message) {
				//console.log(message);
				//1.解析并显示员工数据
				build_books_table(message);
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
		var bookName_query_input=$("#bookName_query_input").val();
		var ISBNNumber_query_input=$("#ISBNNumber_query_input").val();
		var book_query_input=$("#book_type_query_select").val();
		//alert(bookName_query_input+"-"+ISBNNumber_query_input+"-"+book_query_input);
		if(bookName_query_input !== ''){
			jsonstr["bookName"] = bookName_query_input;
		}
		if(ISBNNumber_query_input !== ''){
			jsonstr["ISBNNumber"] = ISBNNumber_query_input;
		}
		if(book_query_input !== null){
			jsonstr["book_type"] = book_query_input;
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

	function build_books_table(message) {
		//清空table 表格
		//books_table tbody
		$("#books_table tbody").empty();
		var books = message.extend.pageInfo.list;
		$.each(books, function(index, item) {
			var checkBoxTd=$("<td><input type='checkbox' class='each_checkbox'/></td>");
			var id = $("<td></td>").append(item.id);
			var isbnnumber = $("<td></td>").append(item.isbnnumber);
			var bookName = $("<td></td>").append(item.bookName);
			var price = $("<td></td>").append(item.price);
			var press = $("<td></td>").append(item.press);
			var writer = $("<td></td>").append(item.writer);
			var book_type = $("<td></td>").append(item.book_type);
			var borrow_type = $("<td></td>").append(item.borrow_type);
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
						.append(isbnnumber)
						.append(bookName)
						.append(price)
						.append(press)
						.append(writer)
						.append(book_type)
						.append(borrow_type)
						.append(btnTd)
						.appendTo("#books_table tbody")
		})
	}
	//单个删除
	$(document).on("click",".delete_btn",function(){
		 //1.弹出是否确认删除对话框
		 var bookName = $(this).parents("tr").find("td:eq(3)").text();
		 var bookId = $(this).attr("del-id");
		 //alert($(this).parents("tr").find("td:eq(1)").text());
		 if(confirm("确定删除图书["+bookName+"]吗?")){
			 //确认.发送ajax请求删除
			 $.ajax({
				 url:"${APP_PATH}/books/del/"+bookId,
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
	$("#book_delete_all").click(function(){
		var bookNames="";
		var ids="";
		$.each($(".each_checkbox:checked"),function(){
			bookNames=bookNames+($(this).parents("tr").find("td:eq(3)").text())+",";
			ids=ids+($(this).parents("tr").find("td:eq(1)").text())+"-";
		});
		bookNames=bookNames.substring(0,bookNames.length-1);
		ids=ids.substring(0,ids.length-1);
		if(confirm("确认删除图书"+bookNames+"吗")){
			$.ajax({
			url:"${APP_PATH}/books/del/"+ids,
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
	$("#book_add_modal_btn").click(function(){
		//清除表单数据(表单完整重置(表单的数据，表单的样式))
		reset_form("#bookAddModal form");
		$("#bookAddModal form")[0].reset();
		//发送ajax请求，查出图书类型，显示在下拉列表中
		getBookType("#book_type_add_select");
		getBorrowType("#borrow_type_add_select");
		//弹出模态框
		$("#bookAddModal").modal({ //利用js创建模态框
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
		/*var bookName=$("#bookName_add_input").val();
		var regbookName=/(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
		if(!regbookName.test(bookName)){
			show_validate_msg("#bookName_add_input","error","图书名称只能是2-5位中文或者6-16位英文和数字的组合");
			return false;
		}else{
			show_validate_msg("#bookName_add_input","success"," ");
			};*/
			
		var ISBNNumber=$("#ISBNNumber_add_input").val();
		var regISBNNumber=/(^[a-zA-Z0-9_-]{6,16}$)/;
		if(!regISBNNumber.test(ISBNNumber)){
			show_validate_msg("#ISBNNumber_add_input","error","序列号只能是6-16为英文和数字组合");
			return false;
		}else{
			show_validate_msg("#ISBNNumber_add_input","success"," ");
		};
		
		var price=$("#price_add_input").val();
		var regprice=/(^[1-9]\d*(\.\d{1,2})?$)|(^0(\.\d{1,2})?$)/;
		if(!regprice.test(price)){
			show_validate_msg("#price_add_input","error","价格只能是正整数或小数");
			return false;
		}else{
			show_validate_msg("#price_add_input","success"," ");
		}
		var press=$("#press_add_input").val();
		var regpress=/(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{1,15})/;
		if(!regpress.test(press)){
			show_validate_msg("#press_add_input","error","出版社只能是2-15位中文或者6-16位英文和数字的组合");
			return false;
		}else{
			show_validate_msg("#press_add_input","success"," ");
		}
		var writer=$("#writer_add_input").val();
		if(writer == null||writer == undefined||writer==''){
			show_validate_msg("#writer_add_input","error","作者不能为空");
			return false;
		}else{
			show_validate_msg("#writer_add_input","success"," ");
			return true;
		}
	};
	//后台校验
	$("#bookName_add_input").change(function(){
		var bookName=this.value;
		$.ajax({
			url:"${APP_PATH}/checkBookName",
			type:"POST",
			data:"bookName="+bookName,
			success:function(message){
				if(message.errorCode == 200){
					show_validate_msg("#bookName_add_input","success","图书名称正常可用");
					$("#bookName_add_input").attr("ajax_bookname","success");
				}else{
					show_validate_msg("#bookName_add_input","error",message.extend.ajax_bookname_msg);
					$("#bookName_add_input").attr("ajax_bookname","error");
				};
			}
		});
	})
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
	$("#book_save_btn").click(function(){
		//校验post数据
		if(!validate_add_form()){
			return false;
		}
		//ajax后台校验
		if(!$(this).attr("ajax_bookname") == "error"){
			return false;
		};
		//发送ajax请求
		$.ajax({
			url:"${APP_PATH}/books/add",
			type:"POST",
			data:$("#bookAddModal form").serialize(),
			success:function(message){
				if(message.errorCode == 200){
					//关闭模态框
					$("#bookAddModal").modal("hide");
					to_page(99999);
				}else{
					alert(message.errorCode);
				}
			}
		});
	})
	//编辑
	$(document).on("click",".edit_btn",function(){
		//下拉框
		getBookType("#book_type_update_select");
		getBorrowType("#borrow_type_update_select");
		//根据当前ID查询出图书信息，并展示
		getBook($(this).attr("edit-id"));
		//id传给模态框的更新按钮
		$("#book_update_btn").attr("update-id",$(this).attr("edit-id"));
		//弹出模态框
		$("#bookUpdateModal").modal({
			backdrop : "static"
		});
	})
	function getBook(id){
		$.ajax({
			url:"${APP_PATH}/books/"+id,
			type:"GET",
			success:function(message){
				var book = message.extend.book;
				$("#bookName_update_static").text(book.bookName);
				$("#ISBNNumber_update_input").val(book.isbnnumber);
				$("#price_update_input").val(book.price);
				$("#press_update_input").val(book.press);
				$("#writer_update_input").val(book.writer);
				//$("#book_type_update_select").val([book.list.book_type]);
				//$("#borrow_type_update_select").val([book.list.borrow_type]);
			}
		});
	}
	//更新
	$("#book_update_btn").click(function(){
		//校验post数据
		//提交请求
		var jsonData = $("#bookUpdateModal form").serializeArray();//json对象http://blog.csdn.net/csdnzhangtao5/article/details/52981541
		jsonData.push({"name":"id","value":$(this).attr("update-id")});
		//var strData = $("#bookUpdateModal form").serialize();//字符串也可以
		//strData=strData+"&"+"id="+$(this).attr("update-id");
		//可以在浏览器中直接输入$("#bookUpdateModal form").serialize();回车调试
		$.ajax({
			url:"${APP_PATH}/books/update",
			type:"POST",
			//data:strData,
			data:jsonData,
			success:function(message){
				if(message.errorCode == 200){
					$("#bookUpdateModal").modal("hide");
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