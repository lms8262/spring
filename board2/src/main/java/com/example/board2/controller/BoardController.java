package com.example.board2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.board2.service.BoardService;
import com.example.board2.util.MyUtil;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@Autowired
	MyUtil myUtil;
	
	@RequestMapping(value = "/") // localhost로 접속
	public String index() {
		return "index";
	}
	// get 방식으로 request가 들어올때
	// 게시글 등록 페이지를 보여줌
	@RequestMapping(value = "/created", method = RequestMethod.GET)
	public String created() {
		return "bbs/created";
	}
	
	// 게시글 등록
	@RequestMapping(value = "/created", method = RequestMethod.POST)
	public String createdOK() {
		try {
			int maxNum = boardService.maxNum();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "bbs/list";
	}
	
	@RequestMapping(value = "/updated", method = RequestMethod.GET)
	public String updated() {
		return "bbs/updated";
	}
	
	@RequestMapping(value = "/article", method = RequestMethod.GET)
	public String article() {
		return "bbs/article";
	}
}
