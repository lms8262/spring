package com.example.board2.service;

import com.example.board2.dto.Board;

public interface BoardService {
	public int maxNum() throws Exception;

	public void insertData(Board board) throws Exception;
}
