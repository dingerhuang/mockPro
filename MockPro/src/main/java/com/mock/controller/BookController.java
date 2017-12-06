package com.mock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mock.entity.Book;
import com.mock.entity.Message;
import com.mock.service.BookService;
import com.mock.vo.BookQueryVo;

@Controller
public class BookController {
	private final static Logger log = LogManager.getLogger(BookController.class);
	@Autowired
	private BookService bookService;
	/*
	 * 按照条件查询所有数据
	 */
	
	@RequestMapping(value="/books")
	@ResponseBody
	public Message getBookPageInfo(BookQueryVo bookQueryVo){
		log.info("begin:"+bookQueryVo.getPn()+bookQueryVo.getBook_type()
		+bookQueryVo.getBookName()+bookQueryVo.getISBNNumber());
		int pn = bookQueryVo.getPn();
		//页码及每页大小
		//int pn=1;
		PageHelper.startPage(pn,15);
		//查询所有数据
		List<Book> books = bookService.getBookList(bookQueryVo);
		PageInfo pageInfo = new PageInfo(books,5);
		
		return Message.sucess().add("pageInfo", pageInfo);
	}
	/*
	 * 根据ID查询数据
	 */
	@RequestMapping(value="books/{id}")
	@ResponseBody
	public Message getBookInfo(@PathVariable("id")int id){
		try {
			Book book = bookService.getBook(id);
			return Message.sucess().add("book", book);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Message.fail();
	}
	/*
	 * 删除
	 */
	@RequestMapping(value="books/del/{ids}")
	@ResponseBody
	public Message delBook(@PathVariable("ids")String ids){
		//List<String> idList = Arrays.asList(ids.split(","));
		ArrayList<Integer> idList = new ArrayList<>();
		/*Array idLists = new Array();如果这里定义为array，
		那么bookMapper.xml文件中collection也需要设置为array
		*/
		String[] str_idList = ids.split("-");
		try {
			if(ids.contains("-")){
				for(String id:str_idList){
					idList.add(Integer.parseInt(id));
				}
				bookService.delBacthBook(idList);
				
				return Message.sucess();
			}else{
				bookService.delBook(Integer.parseInt(ids));
				
				return Message.sucess();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Message.fail();
	}
	/*
	 * update
	 */
	@RequestMapping(value="/books/update")
	@ResponseBody
	//前端以字符串:a=1&b=2或者json格式字符串或者json对象均可自动转为实体
	public Message updateBook(Book book){
		try {
			bookService.updateBook(book);
			return Message.sucess();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Message.fail();
	}
	/*
	 * add
	 */
	@RequestMapping(value="/books/add")
	@ResponseBody
	public Message saveBook(@Valid Book book,BindingResult br){
		if(br.hasErrors()){
			Map<String, Object> map = new HashMap<>();
			List<FieldError> errors = br.getFieldErrors();
			for(FieldError fieldError:errors){
				log.info("错误的字段名:"+ fieldError.getField());  
				log.info("错误信息:"+fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Message.fail().add("fieldErrors", map);
		}else{
			try {
				bookService.saveBook(book);
				return Message.sucess();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return Message.fail();
	}
	/**
	 * 检查图书名称是否可用
	 * @param empName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkBookName")
	public Message checkuse(String bookName){
		//先判断用户名是否是合法的表达式
		String regx="(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		
		if(!(bookName.matches(regx))){
			return Message.fail().add("ajax_bookname_msg","用户名必须是6-16位数字和字母的组合或者2-5位中文");
		}
		
		return Message.sucess().add("ajax_bookname_msg", "success");
	}

}
