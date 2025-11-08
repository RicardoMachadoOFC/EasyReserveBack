package net.javaguides.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestesController {

	@GetMapping("/")
	public ResponseEntity<String> home() {
		return ResponseEntity.ok("teste funcional");
	}
}
