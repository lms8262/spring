package com.example.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reservation.dao.AirplaneDao;
import com.example.reservation.dao.ReservationDao;
import com.example.reservation.dto.Airplane;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDao reservationMapper;

	@Autowired
	private AirplaneDao airplaneMapper;

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

}
