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
import com.example.reservation.dto.Reservation;
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
	// 메인화면, 검색, created페이지 등록하기 및 작성취소 버튼, airplane페이지 삭제 및 목록으로 버튼
	@RequestMapping(value = "/index", method = { RequestMethod.GET, RequestMethod.POST })
	public String index(Airplane airplane, HttpServletRequest request, Model model) {

		try {
			String pageNum = request.getParameter("pageNum");
			if(pageNum == null) {
				pageNum = "1"; // 디폴트 값
			}
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
			int totalPage = myUtil.getPageCount(numPerPage, dataCount);
			
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
			
			String createdUrl = "/created?pageNum=" + pageNum;
			
			if(!param.equals("")) {
				createdUrl += "&" + param;
			}
			
			model.addAttribute("lists", lists); // 전체 데이터 리스트
			model.addAttribute("airplaneUrl", airplaneUrl); // 상세페이지 url
			model.addAttribute("airplanePageIndexList", airplanePageIndexList); // 버튼
			model.addAttribute("dataCount", dataCount); // 전체 데이터 리스트
			model.addAttribute("createdUrl", createdUrl);
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "항공편 리스트를 불러오는 중 에러가 발생했습니다.");
		}

		return "rss/index";
	}

	// 항공편 등록 페이지 보여주기
	// index페이지 항공편 등록 버튼
	@RequestMapping(value = "/created", method = RequestMethod.GET)
	public String created(HttpServletRequest request, Model model) {
		String pageNum = request.getParameter("pageNum");
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		String param = "?pageNum=" + pageNum;
		try {
			
			if(searchValue != null && !searchValue.equals("")) {
				param += "&searchKey=" + searchKey;
				param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8"); // 컴퓨터의 언어로 인코딩
			}
			
			model.addAttribute("params", param);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "항공편 등록 페이지를 불러오는 중 에러가 발생했습니다.");
			return "rss/index";
		}
		
		return "rss/created";
	}

	// 항공편 등록
	// created페이지 등록하기 버튼
	@RequestMapping(value = "/created", method = RequestMethod.POST)
	public String createdOK(Airplane airplane, HttpServletRequest request, Model model) {
		try {
			int maxNum = reservationService.maxNumOfAirplane();
			
			airplane.setAirplane_no(maxNum + 1);
			
			reservationService.insertAirplaneData(airplane);
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "항공편 등록 중 에러가 발생했습니다.");
			return "rss/created";
		}
		
		return "redirect:/index";
	}

	// index화면에서 편명 클릭 시 이동하는 항공편 상세 페이지
	// index페이지 편명 클릭, updated페이지 수정취소 버튼, reservation페이지 작성취소 버튼
	@RequestMapping(value = "/airplane", method = { RequestMethod.GET, RequestMethod.POST })
	public String airplane(Reservation reservation, HttpServletRequest request, Model model) {
		try {
			int airplane_no = Integer.parseInt(request.getParameter("airplane_no"));
			String pageNum = request.getParameter("pageNum");
			String pageNum2 = request.getParameter("pageNum2");
			String searchKey = request.getParameter("searchKey");
			String searchValue = request.getParameter("searchValue");
			
			if (searchValue != null) {
				searchValue = URLDecoder.decode(searchValue, "UTF-8");
			}
			
			// 비행기 데이터 가져오기
			Airplane airplane = reservationService.getReadAirplaneData(airplane_no);
			if(airplane == null) {
				return "redirect:/index?pageNum=" + pageNum;
			}
			
			String param = "pageNum=" + pageNum;
			
			if(searchValue != null && !searchValue.equals("")) {
				param += "&searchKey=" + searchKey;
				param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8"); // 컴퓨터의 언어로 인코딩
			}
			
			// 예약자 리스트 보여주기
			int currentPage = 1;
			
			if(pageNum2 != null) {
				currentPage = Integer.parseInt(pageNum2);
			}
			
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
			
			// 1. 예약자 수를 가져온다
			int dataCount = reservationService.getReservationDataCount(airplane_no);
			
			// 2. 페이징 처리를 한다 (준비 단계)
			int numPerPage = 5; // 페이지당 보여줄 데이터의 개수
			int totalPage = myUtil.getPageCount(numPerPage, dataCount);
			
			if (currentPage > totalPage) {
				currentPage = totalPage; // totalPage보다 크면 안된다
			}
			
			int start = (currentPage - 1) * numPerPage + 1; // 1 6 11...
			int end = currentPage * numPerPage; // 5 10 15...
			
			// 3. 전체 예약자 리스트를 가져온다
			List<Reservation> lists = reservationService.getReservationLists(airplane_no, start, end);
			
			// 4. 페이징 처리를 한다
			
			String airplaneUrl = "/airplane?" + param;
			
			String reservationPageIndexList = myUtil.reservationPageIndexList(airplane_no ,currentPage, totalPage, airplaneUrl);
			
			// 버튼 눌렀을때 상세페이지 주소
			String reservation_statusUrl = "/reservation_status?pageNum2=" + currentPage + "&airplane_no=" + airplane_no;
			
			if(!param.equals("")) { //검색어가 있는 경우
				reservation_statusUrl += "&" + param;
			}
			
			String param2 = param + "&pageNum2=" + currentPage; 
			
			String airplane_name = airplane.getAirplane_name();
			
			model.addAttribute("airplane_name", airplane_name);
			model.addAttribute("airplane", airplane);
			model.addAttribute("params", param);
			model.addAttribute("params2", param2);
			model.addAttribute("lists", lists); // 전체 데이터 리스트
			model.addAttribute("reservation_statusUrl", reservation_statusUrl); // 상세페이지 url
			model.addAttribute("reservationPageIndexList", reservationPageIndexList); // 버튼
			model.addAttribute("dataCount", dataCount); // 전체 데이터 리스트
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "항공편 정보와 예약정보 리스트를 불러오는 중 에러가 발생했습니다.");
			return "rss/index";
		}
		
		return "rss/airplane";
	}

	// 항공편 수정 페이지
	// airplane페이지 정보수정 버튼
	@RequestMapping(value = "/updated", method = RequestMethod.GET)
	public String updated(HttpServletRequest request, Model model) {
		try {
			int airplane_no = Integer.parseInt(request.getParameter("airplane_no"));
			String pageNum = request.getParameter("pageNum");
			String pageNum2 = request.getParameter("pageNum2");
			String searchKey = request.getParameter("searchKey");
			String searchValue = request.getParameter("searchValue");
			
			if (searchValue != null) {
				searchValue = URLDecoder.decode(searchValue, "UTF-8");
			}
			
			Airplane airplane = reservationService.getAirplaneData(airplane_no);
			
			if(airplane == null) {
				return "redirect:/index?pageNum=" + pageNum;
			}
			
			String param = "pageNum=" + pageNum + "&pageNum2=" + pageNum2;
			
			if (searchValue != null && !searchValue.equals("")) {
				// 검색어가 있다면
				param += "&searchKey=" + searchKey;
				param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8"); // 컴퓨터의 언어로 인코딩
			}
			
			model.addAttribute("airplane", airplane);
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("pageNum2", pageNum2);
			model.addAttribute("params", param);
			model.addAttribute("searchKey", searchKey);
			model.addAttribute("searchValue", searchValue);
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "항공편 정보 수정 페이지를 불러오는 중 에러가 발생했습니다.");
		}
		return "rss/updated";
	}

	// 항공편 수정
	// updated페이지 수정하기 버튼
	@RequestMapping(value = "/updated_ok", method = RequestMethod.POST)
	public String updatedOK(Airplane airplane, HttpServletRequest request, Model model) {
		String pageNum = request.getParameter("pageNum");
		String pageNum2 = request.getParameter("pageNum2");
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		String param = "?pageNum=" + pageNum + "&pageNum2=" + pageNum2 + "&airplane_no=" + airplane.getAirplane_no(); 
		
		try {
			reservationService.updateAirplaneData(airplane);
			
			if (searchValue != null && !searchValue.equals("")) {
				// 검색어가 있다면
				param += "&searchKey=" + searchKey;
				param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8"); // 컴퓨터의 언어로 인코딩
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "항공편 정보를 수정하는 중 에러가 발생했습니다.");
			return "rss/index";
		}
		
		return "redirect:/airplane" + param;
	}

	// 항공편 삭제
	// airplane페이지 삭제 버튼
	@RequestMapping(value = "/deleted_airplane_ok", method = RequestMethod.GET)
	public String deletedAirplaneOK(HttpServletRequest request, Model model) {
		int airplane_no = Integer.parseInt(request.getParameter("airplane_no"));
		String pageNum = request.getParameter("pageNum");
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		String param = "?pageNum=" + pageNum;
		
		try {
			reservationService.deleteAirplaneData(airplane_no);
			
			if (searchValue != null && !searchValue.equals("")) {
				// 검색어가 있다면
				param += "&searchKey=" + searchKey;
				param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8"); // 컴퓨터의 언어로 인코딩
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "항공편을 삭제하는 중 에러가 발생했습니다.");
			return "rss/index";
		}
		
		return "redirect:/index" + param;
	}

	// 예약 정보 입력 페이지 보여주기
	// airplane페이지 예약버튼
	@RequestMapping(value = "/reservation", method = RequestMethod.GET)
	public String reservation(HttpServletRequest request, Model model) {
		try {
			int airplane_no = Integer.parseInt(request.getParameter("airplane_no"));
			String airplane_name = request.getParameter("airplane_name");
			String pageNum = request.getParameter("pageNum");
			String pageNum2 = request.getParameter("pageNum2");
			String searchKey = request.getParameter("searchKey");
			String searchValue = request.getParameter("searchValue");
			String param = "pageNum=" + pageNum + "&pageNum2=" + pageNum2;
			
			if (searchValue != null) {
				searchValue = URLDecoder.decode(searchValue, "UTF-8");
			}
			
			if (searchValue != null && !searchValue.equals("")) {
				// 검색어가 있다면
				param += "&searchKey=" + searchKey;
				param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8"); // 컴퓨터의 언어로 인코딩
			}
			
			model.addAttribute("airplane_name", airplane_name);
			model.addAttribute("airplane_no", airplane_no);
			model.addAttribute("params", param);
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("pageNum2", pageNum2);
			model.addAttribute("searchKey", searchKey);
			model.addAttribute("searchValue", searchValue);
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "예약 정보 입력 페이지를 불러오는 중 에러가 발생했습니다.");
			return "rss/index";
		}
		
		return "rss/reservation";
	}

	// 예약
	// reservation페이지 예약하기 버튼
	@RequestMapping(value = "/reservation", method = RequestMethod.POST)
	public String reservationOK(Reservation reservation, HttpServletRequest request, Model model) {
			String pageNum = request.getParameter("pageNum");
			String pageNum2 = request.getParameter("pageNum2");
			String searchKey = request.getParameter("searchKey");
			String searchValue = request.getParameter("searchValue");
			String param = "?pageNum=" + pageNum + "&pageNum2=" + pageNum2 + "&airplane_no=" + reservation.getAirplane_no();
			
		try {
			int maxNum = reservationService.maxNumOfReservation();
			
			reservation.setReservation_no(maxNum + 1);
			
			reservationService.insertReservationData(reservation);
			
			if (searchValue != null && !searchValue.equals("")) {
				// 검색어가 있다면
				param += "&searchKey=" + searchKey;
				param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8"); // 컴퓨터의 언어로 인코딩
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "예약 중에 에러가 발생했습니다.");
			return "rss/index";
		}
		
		return "redirect:/airplane" + param;
	}

	// 에약 상세정보 보기
	// airplane페이지 예약자명 클릭, reservation_updated 돌아가기
	@RequestMapping(value = "/reservation_status", method = RequestMethod.GET)
	public String reservationStatus(HttpServletRequest request, Model model) {
		try {
			int reservation_no = Integer.parseInt(request.getParameter("reservation_no"));
			int airplane_no = Integer.parseInt(request.getParameter("airplane_no"));
			String pageNum = request.getParameter("pageNum");
			String pageNum2 = request.getParameter("pageNum2");
			String searchKey = request.getParameter("searchKey");
			String searchValue = request.getParameter("searchValue");
			
			if (searchValue != null) {
				searchValue = URLDecoder.decode(searchValue, "UTF-8");
			}
			
			// 예약정보 가져오기
			Reservation reservation = reservationService.getReadReservationData(reservation_no);
			String airplane_name = reservationService.getAirplaneName(reservation_no);
			if(reservation == null) {
				return "redirect:/airplane?pageNum=" + pageNum + "&airplane_no=" + airplane_no;
			}
			
			String param = "pageNum=" + pageNum + "&airplane_no=" + airplane_no + "&pageNum2=" + pageNum2;
			
			if (searchValue != null && !searchValue.equals("")) {
				// 검색어가 있다면
				param += "&searchKey=" + searchKey;
				param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8"); // 컴퓨터의 언어로 인코딩
			}
			
			model.addAttribute("reservation", reservation);
			model.addAttribute("airplane_name", airplane_name);
			model.addAttribute("params", param);
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("pageNum2", pageNum2);
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "예약 상세정보를 불러오는 중에 에러가 발생했습니다.");
			return "rss/index";
		}
		
		return "rss/reservation_status";
	}

	// 예약 정보 수정 페이지 보여주기
	// reservation_status페이지 예약수정 버튼
	@RequestMapping(value = "/reservation_updated", method = RequestMethod.GET)
	public String reservation_updated(HttpServletRequest request, Model model) {
		try {
			int reservation_no = Integer.parseInt(request.getParameter("reservation_no"));
			int airplane_no = Integer.parseInt(request.getParameter("airplane_no"));
			String pageNum = request.getParameter("pageNum");
			String pageNum2 = request.getParameter("pageNum2");
			String searchKey = request.getParameter("searchKey");
			String searchValue = request.getParameter("searchValue");
			
			if (searchValue != null) {
				searchValue = URLDecoder.decode(searchValue, "UTF-8");
			}
			
			Reservation reservation = reservationService.getReadReservationData(reservation_no);
			String airplane_name = reservationService.getAirplaneName(reservation_no);
			
			if(reservation == null) {
				return "redirect:/airplane?airplane_no=" + airplane_no;
			}
			
			String param = "pageNum=" + pageNum + "&pageNum2=" + pageNum2;
			
			if (searchValue != null && !searchValue.equals("")) {
				// 검색어가 있다면
				param += "&searchKey=" + searchKey;
				param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8"); // 컴퓨터의 언어로 인코딩
			}
			
			model.addAttribute("reservation", reservation);
			model.addAttribute("airplane_name", airplane_name);
			model.addAttribute("params", param);
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("pageNum2", pageNum2);
			model.addAttribute("searchKey", searchKey);
			model.addAttribute("searchValue", searchValue);
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "예약 수정 페이지를 불러오는 중에 에러가 발생했습니다.");
			return "rss/index";
		}
		
		return "rss/reservation_updated";
	}

	// 예약 정보 수정
	// reservation_updated페이지 수정하기 버튼
	@RequestMapping(value = "/reservation_updated", method = RequestMethod.POST)
	public String reservation_updatedOK(Reservation reservation, HttpServletRequest request, Model model) {
		String pageNum = request.getParameter("pageNum");
		String pageNum2 = request.getParameter("pageNum2");
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		String param = "?pageNum=" + pageNum + "&pageNum2=" + pageNum2 + "&airplane_no=" + reservation.getAirplane_no() + "&reservation_no=" + reservation.getReservation_no();
		
		try {
			reservationService.updateReservationData(reservation);
			
			if (searchValue != null && !searchValue.equals("")) {
				// 검색어가 있다면
				param += "&searchKey=" + searchKey;
				param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8"); // 컴퓨터의 언어로 인코딩
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "예약 정보를 수정하는 중에 에러가 발생했습니다.");
			return "rss/index";
		}
		
		return "redirect:/reservation_status" + param;
	}

	// 예약 취소(삭제)
	// reservation_status페이지 예약취소 버튼
	@RequestMapping(value = "/deleted_reservation_ok", method = RequestMethod.GET)
	public String deletedReservationOK(HttpServletRequest request, Model model) {
		int reservation_no = Integer.parseInt(request.getParameter("reservation_no"));
		int airplane_no = Integer.parseInt(request.getParameter("airplane_no"));
		String pageNum = request.getParameter("pageNum");
		String pageNum2 = request.getParameter("pageNum2");
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		String param = "?pageNum=" + pageNum + "&pageNum2=" + pageNum2 + "&airplane_no=" + airplane_no;
		
		try {
			reservationService.deleteReservationData(reservation_no);
			
			if (searchValue != null && !searchValue.equals("")) {
				// 검색어가 있다면
				param += "&searchKey=" + searchKey;
				param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8"); // 컴퓨터의 언어로 인코딩
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", "예약을 취소하는 중에 에러가 발생했습니다.");
			return "rss/index";
		}
		return "redirect:/airplane" + param;
	}
}
