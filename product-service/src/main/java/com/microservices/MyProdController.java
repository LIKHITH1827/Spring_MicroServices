package com.microservices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyProdController {
     
	@GetMapping
	public ResponseEntity<String>  getProducts(){
		String st = "Apple";
		return ResponseEntity.ok(st);
	}
	
}
