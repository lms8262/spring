package com.example.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reservation.dao.AirplaneDao;
import com.example.reservation.dao.ReservationDao;
import com.example.reservation.dto.Airplane;
import com.example.reservation.dto.Reservation;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDao reservationMapper;

	@Autowired
	private AirplaneDao airplaneMapper;

	// 비행기 관련
	@Override
	public int maxNumOfAirplane() throws Exception {
		return airplaneMapper.maxNumOfAirplane();
	}

	@Override
	public int getAirplaneDataCount(String searchKey, String searchValue) throws Exception {
		return airplaneMapper.getAirplaneDataCount(searchKey, searchValue);
	}

	@Override
	public List<Airplane> getAirplaneLists(String searchKey, String searchValue, int start, int end) throws Exception {
		return airplaneMapper.getAirplaneLists(searchKey, searchValue, start, end);
	}

	@Override
	public void insertAirplaneData(Airplane airplane) throws Exception {
		airplaneMapper.insertAirplaneData(airplane);
	}

	@Override
	public Airplane getReadAirplaneData(int airplane_no) throws Exception {
		return airplaneMapper.getReadAirplaneData(airplane_no);
	}

	@Override
	public void minusLeftSeat(int airplane_no) throws Exception {
		airplaneMapper.minusLeftSeat(airplane_no);
	}

	@Override
	public void plusLeftSeat(int airplane_no) throws Exception {
		airplaneMapper.plusLeftSeat(airplane_no);
	}

	@Override
	public Airplane getAirplaneData(int airplane_no) throws Exception {
		return airplaneMapper.getAirplaneData(airplane_no);
	}

	@Override
	public void updateAirplaneData(Airplane airplane) throws Exception {
		airplaneMapper.updateAirplaneData(airplane);
	}

	@Override
	public void deleteAirplaneData(int airplane_no) throws Exception {
		airplaneMapper.deleteAirplaneData(airplane_no);
	}

	// 예약 관련
	@Override
	public int maxNumOfReservation() throws Exception {
		return reservationMapper.maxNumOfReservation();
	}

	@Override
	public int getReservationDataCount(int airplane_no) throws Exception {
		return reservationMapper.getReservationDataCount(airplane_no);
	}

	@Override
	public List<Reservation> getReservationLists(int airplane_no, int start, int end) throws Exception {
		return reservationMapper.getReservationLists(airplane_no, start, end);
	}

	@Override
	public void insertReservationData(Reservation reservation) throws Exception {
		reservationMapper.insertReservationData(reservation);
	}

	@Override
	public Reservation getReadReservationData(int reservation_no) throws Exception {
		return reservationMapper.getReadReservationData(reservation_no);
	}

	@Override
	public String getAirplaneName(int reservation_no) throws Exception {
		return reservationMapper.getAirplaneName(reservation_no);
	}

	@Override
	public void updateReservationData(Reservation reservation) throws Exception {
		reservationMapper.updateReservationData(reservation);
	}

	@Override
	public void deleteReservationData(int reservation_no) throws Exception {
		reservationMapper.deleteReservationData(reservation_no);
	}

}
