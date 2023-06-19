package com.example.board2.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.board2.dto.Board;

@Mapper
public interface BoardDao {
	public int maxNum() throws Exception;

	public void insertData(Board board) throws Exception;
}
