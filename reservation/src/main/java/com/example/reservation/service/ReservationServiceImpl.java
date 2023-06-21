package com.example.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reservation.dao.AirplaneDao;
import com.example.reservation.dao.ReservationDao;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationDao reservationMapper;
	
	@Autowired
	private AirplaneDao airplaneMapper;

}
