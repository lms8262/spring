package com.example.reservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reservation {
	private int reservation_no; // 예약 번호
	private int airplane_no; // 비행기 번호
	private String user_name; // 예약자명
	private String user_email; // 예약자 이메일
	private String user_phone; // 예약자 비밀번호
	private String reservation_date; // 예약일자
}
