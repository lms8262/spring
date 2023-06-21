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

	@RequestMapping(value = "/")
	public String main() {
		return "rss/index";
	}

	@RequestMapping(value = "/index")
	public String index() {
		return "rss/index";
	}

	@RequestMapping(value = "/created", method = RequestMethod.GET)
	public String created() {
		return "rss/created";
	}
	
	@RequestMapping(value = "/created", method = RequestMethod.POST)
	public String createdOK() {
		return "redirect:/index";
	}

	@RequestMapping(value = "/airplane")
	public String airplane() {
		return "rss/airplane";
	}
	
	@RequestMapping(value = "/updated")
	public String updated() {
		return "rss/updated";
	}
	
	@RequestMapping(value = "/reservation")
	public String reservation() {
		return "rss/reservation";
	}
	
	@RequestMapping(value = "/list")
	public String list() {
		return "rss/list";
	}
}
