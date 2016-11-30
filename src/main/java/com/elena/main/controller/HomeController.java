package com.elena.main.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public ResponseEntity<String> home() {
		
		return new ResponseEntity<String>("This is the homepage", new HttpHeaders(), HttpStatus.OK);
	}


}
