package com.example.reservation.util;

import org.springframework.stereotype.Service;

@Service
public class MyUtil {
	// 전체 페이지의 개수를 구한다(airplane)
	public int getPageCount(int numPerPage, int dataCount) {
		int pageCount = 0;
		pageCount = dataCount / numPerPage;

		if (dataCount % numPerPage != 0) {
			pageCount++;
		}
		return pageCount;
	}

	public String airplanePageIndexList(int currentPage, int totalPage, String indexUrl) {
		StringBuffer sb = new StringBuffer();
		int numPerBlock = 5; // ◀이전 6 7 8 9 10 다음▶ 이전과 다음 사이에 숫자 몇개를 표시할지
		int currentPageSetup; // ◀이전 버튼에 들어갈 값
		int page; // 그냥 페이지 숫자를 클릭했을때 들어갈 값

		if (currentPage == 0 || totalPage == 0) { // 데이터가 없는 경우
			return "";
		}

		// 검색어가 있을때
		if (indexUrl.indexOf("?") != -1) {
			// 쿼리스트링이 있는 경우
			indexUrl += "&";
		} else { // 쿼리스트링이 없는 경우
			indexUrl += "?";
		}

		// 1. ◀이전 버튼 만들기
		currentPageSetup = (currentPage / numPerBlock) * numPerBlock;
		
		if(currentPage % numPerBlock == 0) {
			currentPageSetup = currentPageSetup - numPerBlock;
		}
		
		if(totalPage > numPerBlock && currentPageSetup > 0) {
			sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\"" + indexUrl + "pageNum=" + currentPageSetup + "\">←</a></li>");
		}
		
		// 2. 그냥 페이지(1 2 3 4 5) 이동 버튼 만들기
		page = currentPageSetup + 1; // 1 6 11 16...
		
		while(page <= totalPage && page <=(currentPageSetup + numPerBlock)) {
			if(page == currentPage) { //현재 선택한 페이지인 경우
				sb.append("<li class=\"page-item\"><a class=\"page-link active\">" + page +"</a></li>");
			} else { // 현재 선택한 페이지가 아닌 경우
				sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\"" + indexUrl + "pageNum=" + page + "\">" + page + "</a></li>");
			}
			page++;
		}
		
		// 3. 다음▶ 버튼 만들기
		if(totalPage - currentPageSetup > numPerBlock) {
			sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\"" + indexUrl + "pageNum=" + currentPageSetup + "\">→</a></li>");
		}
		
		// 4. 버튼 합쳐서 문자열로 리턴
		return sb.toString();
	}
	
	public String reservationPageIndexList(int airplane_no,int currentPage, int totalPage, String airplaneUrl) {
		StringBuffer sb = new StringBuffer();
		int numPerBlock = 5; // ◀이전 6 7 8 9 10 다음▶ 이전과 다음 사이에 숫자 몇개를 표시할지
		int currentPageSetup; // ◀이전 버튼에 들어갈 값
		int page; // 그냥 페이지 숫자를 클릭했을때 들어갈 값
		
		if (currentPage == 0 || totalPage == 0) { // 데이터가 없는 경우
			return "";
		}
		
		// 검색어가 있을때
		if (airplaneUrl.indexOf("?") != -1) {
			// 쿼리스트링이 있는 경우
			airplaneUrl += "&";
		} else { // 쿼리스트링이 없는 경우
			airplaneUrl += "?";
		}
		
		// 1. ◀이전 버튼 만들기
		currentPageSetup = (currentPage / numPerBlock) * numPerBlock;
		
		if(currentPage % numPerBlock == 0) {
			currentPageSetup = currentPageSetup - numPerBlock;
		}
		
		if(totalPage > numPerBlock && currentPageSetup > 0) {
			sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\"" + airplaneUrl + "&pageNum2=" + currentPageSetup + "&airplane_no=" + airplane_no + "\">←</a></li>");
		}
		
		// 2. 그냥 페이지(1 2 3 4 5) 이동 버튼 만들기
		page = currentPageSetup + 1; // 1 6 11 16...
		
		while(page <= totalPage && page <=(currentPageSetup + numPerBlock)) {
			if(page == currentPage) { //현재 선택한 페이지인 경우
				sb.append("<li class=\"page-item\"><a class=\"page-link active\">" + page +"</a></li>");
			} else { // 현재 선택한 페이지가 아닌 경우
				sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\"" + airplaneUrl + "&pageNum2=" + page + "&airplane_no=" + airplane_no + "\">" + page + "</a></li>");
			}
			page++;
		}
		
		// 3. 다음▶ 버튼 만들기
		if(totalPage - currentPageSetup > numPerBlock) {
			sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\"" + airplaneUrl + "&pageNum2=" + currentPageSetup + "&airplane_no=" + airplane_no + "\">→</a></li>");
		}
		
		// 4. 버튼 합쳐서 문자열로 리턴
		return sb.toString();
	}
}
