package com.example.reservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Airplane {
	private int airplane_no;
	private String airplane_name;
	private String departrue_date;
	private String arrival_date;
	private String departrue;
	private String arrival;
	private int left_seat;
	private int total_seat;
	private int price;
}
