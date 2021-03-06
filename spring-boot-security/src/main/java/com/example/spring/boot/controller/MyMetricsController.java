package com.example.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spring.boot.service.MyMetricsService;

@Controller
@RequestMapping("/mymetrics")
public class MyMetricsController {

	@Autowired
	private MyMetricsService myMetricsService;

	@RequestMapping("/")
	@ResponseBody
	String index() {
		myMetricsService.exampleMethod();
		return "myMetricsService.exampleMethod invoked!";
	}

}