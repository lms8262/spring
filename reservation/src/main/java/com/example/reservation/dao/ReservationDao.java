package com.example.reservation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.reservation.dto.Reservation;

@Mapper
public interface ReservationDao {
	public int maxNumOfReservation() throws Exception;
	
	public int getReservationDataCount(int airplane_no) throws Exception;
	
	public List<Reservation> getReservationLists(int airplane_no, int start, int end) throws Exception;
	
	public void insertReservationData(Reservation reservation) throws Exception;
	
	public Reservation getReadReservationData(int reservation_no) throws Exception;
	
	public String getAirplaneName(int reservation_no) throws Exception;
	
	public void updateReservationData(Reservation reservation) throws Exception;
	
	public void deleteReservationData(int reservation_no) throws Exception;
}
