package com.example.board2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board2.dao.BoardDao;
import com.example.board2.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardMapper;

	@Override
	public int maxNum() throws Exception {
		return boardMapper.maxNum();
	}

	@Override
	public void insertData(Board board) throws Exception {
		boardMapper.insertData(board);
	}

}
