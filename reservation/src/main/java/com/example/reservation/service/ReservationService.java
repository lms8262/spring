package com.example.reservation.service;

import java.util.List;

import com.example.reservation.dto.Airplane;

public interface ReservationService {
	public int maxNumOfAirplane() throws Exception;

	public int getAirplaneDataCount(String searchKey, String searchValue) throws Exception;

	public List<Airplane> getAirplaneLists(String searchKey, String searchValue, int start, int end) throws Exception;

	public void insertAirplaneData(Airplane airplane) throws Exception;
	
}
