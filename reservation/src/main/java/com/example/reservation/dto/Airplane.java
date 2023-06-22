package com.example.reservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Airplane {
	private int airplane_no; // 비행기 번호
	private String airplane_name; // 편명
	private String departrue_date; // 출발일시
	private String arrival_date; // 도착일시
	private String departrue; // 출발지
	private String arrival; // 도착지
	private int left_seat; // 남은 좌석 수
	private int total_seat; // 총 좌석 수
	private int price; // 가격
}
