package com.example.reservation.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.reservation.dto.Airplane;
import com.example.reservation.service.ReservationService;
import com.example.reservation.util.MyUtil;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ReservationController {
	@Autowired
	private ReservationService reservationService;

	@Autowired
	MyUtil myUtil;

	// localhost로 접속 시 index로 이동
	@RequestMapping(value = "/")
	public String main(Airplane airplane, HttpServletRequest request, Model model) {
		return index(airplane, request, model);
	}

	// 항공편 목록이 보이는 메인 페이지
	@RequestMapping(value = "/index", method = { RequestMethod.GET, RequestMethod.POST })
	public String index(Airplane airplane, HttpServletRequest request, Model model) {

		try {
			String pageNum = request.getParameter("pageNum");
			int currentPage = 1;

			if (pageNum != null) {
				currentPage = Integer.parseInt(pageNum);
			}

			String searchKey = request.getParameter("searchKey"); // 검색 키워드
			String searchValue = request.getParameter("searchValue"); // 검색어

			if (searchValue == null) {
				searchKey = "airplane_name"; // 검색 키워드의 디폴트는 airplane_name
				searchValue = "";
			} else {
				if (request.getMethod().equalsIgnoreCase("GET")) {
					// get 방식으로 request가 왔다면
					// 쿼리 파라메터의 값(searchValue)을 디코딩해준다.
					searchValue = URLDecoder.decode(searchValue, "UTF-8");
				}
			}
			
			// 1. 전체 게시물의 개수를 가져온다 (페이징 처리에 필요)
			int dataCount = reservationService.getAirplaneDataCount(searchKey, searchValue);
			
			// 2. 페이징 처리를 한다 (준비 단계)
			int numPerPage = 5; // 페이지당 보여줄 데이터 수
			int totalPage = myUtil.getAirplanePageCount(numPerPage, dataCount);
			
			if(currentPage > totalPage) {
				currentPage = totalPage; // 현재 페이지는 총 페이지 수를 넘어갈 수 없음
			}
			
			int start = (currentPage - 1) * numPerPage + 1; // 1 6 11...
			int end = currentPage * numPerPage; // 5 10 15...
			
			// 3. 전체 게시물 리스트를 가져온다
			List<Airplane> lists = reservationService.getAirplaneLists(searchKey, searchValue, start, end);
			
			// 4. 페이징 처리를 한다
			String param = "";
			
			if(searchValue != null && !searchValue.equals("")) { // 검색어가 있는 경우
				param = "searchKey=" + searchKey;
				param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8"); // 컴퓨터의 언어로 인코딩
			}
			
			String indexUrl = "/index";
			
			if(!param.equals("")) { // 검색어가 있는 경우
				indexUrl += "?" + param;
			}
			
			// 페이징 버튼
			String airplanePageIndexList = myUtil.airplanePageIndexList(currentPage, totalPage, indexUrl);
			
			// 버튼 눌렀을때 상세페이지 주소
			String airplaneUrl = "/airplane?pageNum=" + currentPage;
			
			if(!param.equals("")) { //검색어가 있는 경우
				airplaneUrl += "&" + param;
			}
			
			model.addAttribute("lists", lists); // 전체 데이터 리스트
			model.addAttribute("airplaneUrl", airplaneUrl); // 상세페이지 url
			model.addAttribute("airplanePageIndexList", airplanePageIndexList); // 버튼
			model.addAttribute("dataCount", dataCount); // 전체 데이터 리스트
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "rss/index";
	}

	// 항공편 등록 페이지 보여주기
	@RequestMapping(value = "/created", method = RequestMethod.GET)
	public String created() {
		return "rss/created";
	}

	// 항공편 등록
	@RequestMapping(value = "/created", method = RequestMethod.POST)
	public String createdOK(Airplane airplane, HttpServletRequest request, Model model) {
		try {
			int maxNum = reservationService.maxNumOfAirplane();
			
			airplane.setAirplane_no(maxNum + 1);
			
			reservationService.insertAirplaneData(airplane);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/index";
	}

	// index화면에서 편명 클릭 시 이동하는 항공편 상세 페이지
	@RequestMapping(value = "/airplane", method = { RequestMethod.GET, RequestMethod.POST })
	public String airplane(HttpServletRequest request, Model model) {
		return "rss/airplane";
	}

	// 항공편 수정 페이지
	@RequestMapping(value = "/updated", method = RequestMethod.GET)
	public String updated() {
		return "rss/updated";
	}

	// 항공편 수정
	@RequestMapping(value = "/updated_ok", method = RequestMethod.POST)
	public String updatedOK(Airplane airplane, HttpServletRequest request, Model model) {
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
	@RequestMapping(value = "/reservation", method = RequestMethod.POST)
	public String reservationOK() {
		return "redirect:/index";
	}

	// 에약 상세정보 보기
	@RequestMapping(value = "/reservation_status", method = RequestMethod.GET)
	public String reservationStatus() {
		return "rss/reservation_status";
	}

	// 예약 정보 수정 페이지 보여주기
	@RequestMapping(value = "/reservation_updated", method = RequestMethod.GET)
	public String reservation_updated() {
		return "rss/reservation_updated";
	}

	// 예약 정보 수정
	@RequestMapping(value = "/reservation_updated", method = RequestMethod.POST)
	public String reservation_updatedOK() {
		return "redirect:/index";
	}

	// 예약 취소
	@RequestMapping(value = "/deleted_reservation_ok", method = RequestMethod.GET)
	public String deletedReservationOK() {
		return "redirect:/index";
	}
}
