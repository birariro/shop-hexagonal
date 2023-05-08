package com.challenge.shop_hexagonal.application.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping
	public ResponseEntity hello(){

		return ResponseEntity.ok().body("hello");
	}

}