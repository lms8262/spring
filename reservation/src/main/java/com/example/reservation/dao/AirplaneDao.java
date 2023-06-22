package com.example.reservation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.reservation.dto.Airplane;

@Mapper
public interface AirplaneDao {
	public int maxNumOfAirplane() throws Exception;

	public int getAirplaneDataCount(String searchKey, String searchValue) throws Exception;

	public List<Airplane> getAirplaneLists(String searchKey, String searchValue, int start, int end) throws Exception;

	public void insertAirplaneData(Airplane airplane) throws Exception;

	public Airplane getReadAirplaneData(int airplane_no) throws Exception;

	public void minusLeftSeat(int airplane_no) throws Exception;

	public void plusLeftSeat(int airplane_no) throws Exception;
	
	public Airplane getAirplaneData(int airplane_no) throws Exception;
	
	public void updateAirplaneData(Airplane airplane) throws Exception;
	
	public void deleteAirplaneData(int airplane_no) throws Exception;
}
