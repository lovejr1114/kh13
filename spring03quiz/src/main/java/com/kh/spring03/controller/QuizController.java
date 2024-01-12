package com.kh.spring03.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {
	
	Random r = new Random();
	
	@RequestMapping("/dice")
	public String dice() {
		int a = r.nextInt();
		int dice = r.nextInt(6) + 1;
		return "주사위 = " + dice;
		
	}
}
