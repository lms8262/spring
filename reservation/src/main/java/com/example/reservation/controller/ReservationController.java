package com.example.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.reservation.service.ReservationService;
import com.example.reservation.util.MyUtil;

@Controller
public class ReservationController {
	@Autowired
	private ReservationService ReservationService;

	@Autowired
	MyUtil myUtil;

	// localhost로 접속 시 index로 이동
	@RequestMapping(value = "/")
	public String main() {
		return "rss/index";
	}

	// 항공편 목록이 보이는 메인 페이지
	@RequestMapping(value = "/index", method = { RequestMethod.GET, RequestMethod.POST })
	public String index() {
		return "rss/index";
	}

	// 항공편 등록 페이지 보여주기
	@RequestMapping(value = "/created", method = RequestMethod.GET)
	public String created() {
		return "rss/created";
	}

	// 항공편 등록
	@RequestMapping(value = "/created", method = RequestMethod.POST)
	public String createdOK() {
		return "redirect:/index";
	}

	// index화면에서 편명 클릭 시 이동하는 항공편 상세 페이지
	@RequestMapping(value = "/airplane", method = RequestMethod.GET)
	public String airplane() {
		return "rss/airplane";
	}

	// 항공편 수정 페이지
	@RequestMapping(value = "/updated", method = RequestMethod.GET)
	public String updated() {
		return "rss/updated";
	}

	// 항공편 수정
	@RequestMapping(value = "/updated_ok", method = RequestMethod.POST)
	public String updatedOK() {
		return "redirect:/index";
	}

	// 항공편 삭제
	@RequestMapping(value = "/deleted_airplane_ok", method = RequestMethod.GET)
	public String deletedAirplaneOK() {
		return "redirect:/index";
	}

	// 예약 정보 입력 페이지 보여주기
	@RequestMapping(value = "/reservation", method = RequestMethod.GET)
	public String reservation() {
		return "rss/reservation";
	}

	// 예약
	@RequestMapping(value = "/reservation_ok", method = RequestMethod.POST)
	public String reservationOK() {
		return "redirect:/index";
	}

	// 에약 상세정보 보기
	@RequestMapping(value = "/reservation_status", method = { RequestMethod.GET, RequestMethod.POST })
	public String reservationStatus() {
		return "rss/reservation_status";
	}

	// 예약 정보 수정 페이지 보여주기
	@RequestMapping(value = "/reservation_updated", method = RequestMethod.GET)
	public String reservation_updated() {
		return "rss/reservation_updated";
	}

	// 예약 정보 수정
	@RequestMapping(value = "/reservation_updated_ok", method = RequestMethod.POST)
	public String reservation_updatedOK() {
		return "redirect:/index";
	}

	// 예약 취소
	@RequestMapping(value = "/deleted_reservation_ok", method = RequestMethod.GET)
	public String deletedReservationOK() {
		return "redirect:/index";
	}
}
