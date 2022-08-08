package com.callor.todo.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;

@Controller
@RequestMapping(value="/todo")
public class TodoController {
	
	@Autowired
	TodoService todoService;

	@RequestMapping(value="/todoList", method=RequestMethod.GET)
	public String todo(Model model, Principal principal) {
		
		List<TodoVO> todoList = todoService.selectTodoAll(principal.getName());
		model.addAttribute("todoList", todoList);
		
		return null;
	}
	
	@RequestMapping(value="/todoList", method=RequestMethod.POST)
	public String todo(Principal principal, TodoVO todoVO) {
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");		
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		todoVO.setInsert_date(dateFormat.format(date));
		todoVO.setInsert_time(timeFormat.format(date));
		todoVO.setId(principal.getName());
		
		todoService.insert(todoVO);
		
		return "redirect:/todo/todoList";
	}
	
//	@RequestMapping(value="/complete")
//	public String complete(TodoVO todoVO, Principal principal) {
//		
//	}

//	리스트를 보고 클릭하면 리스트에 대한 시퀀스 값을 컨틀로러에 보내고
//	컨트는 시퀀스값을 서비스에 보내고 게는 findById(seq) 함리턴된 todovo에
//	완료 날짜 세팅, VO에 보내고 업데이트
}
