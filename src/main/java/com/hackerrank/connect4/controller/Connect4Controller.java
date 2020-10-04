package com.hackerrank.connect4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.connect4.exceptions.InvalidColumnException;
import com.hackerrank.connect4.exceptions.InvalidCommandException;
import com.hackerrank.connect4.manager.Gameplay;

@RestController
@RequestMapping("/connect4")
public class Connect4Controller {
	
	@Autowired
	private Gameplay gameplay;
	
	@RequestMapping(path="/{str}")
	public ResponseEntity<String> startNewGame(@PathVariable("str") String str) {
		if(str.equals("START")) {
			gameplay.createNewBoard();
		}
		else {
			throw new InvalidCommandException("Not a valid command- "+str);
		}
		return ResponseEntity.ok("READY");	
	}
	
	@GetMapping("/hello")
	public String Hello() {
		System.out.println("Inside hello");
		return "Hello World!";	
	}
	
	@RequestMapping(path="/play/{col}")
	public ResponseEntity<String> playGame(@PathVariable("col") int col) {
		gameplay.printBoard();
		if(col<1 || col>7)
			throw new InvalidColumnException("Make sure the column is between 1 & 6 ");
		if(gameplay.play(col-1)==true)
			return  ResponseEntity.ok("Valid");
		else
			return ResponseEntity.ok("Invalid");
	}
	
}
