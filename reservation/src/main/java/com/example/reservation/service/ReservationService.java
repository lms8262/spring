package com.example.reservation.service;

import java.util.List;

import com.example.reservation.dto.Airplane;
import com.example.reservation.dto.Reservation;

public interface ReservationService {
	// 비행기 관련
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

	// 예약 관련
	public int maxNumOfReservation() throws Exception;
	
	public int getReservationDataCount(int airplane_no) throws Exception;

	public List<Reservation> getReservationLists(int airplane_no, int start, int end) throws Exception;
	
	public void insertReservationData(Reservation reservation) throws Exception;

	public Reservation getReadReservationData(int reservation_no) throws Exception;

	public String getAirplaneName(int reservation_no) throws Exception;
	
	public void updateReservationData(Reservation reservation) throws Exception;
	
	public void deleteReservationData(int reservation_no) throws Exception;

}
