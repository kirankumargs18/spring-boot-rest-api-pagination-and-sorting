package com.kirangs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kirangs.com")
public class AdminController {

	@GetMapping
	public ResponseEntity<String> welcomeMessage() {
		return new ResponseEntity<String>("<h1>Welcome to my website<h1>", HttpStatus.OK);
	}

}
