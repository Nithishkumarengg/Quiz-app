package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.questionwrapper;
import com.example.demo.model.response;
import com.example.demo.service.quizservice;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("quiz")
public class quizcontroller {
	@Autowired
	quizservice quizservice;

	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numq,
			@RequestParam String title) {
		return quizservice.createquiz(category, numq, title);
	}

	@GetMapping("get/{id}")
	public ResponseEntity<List<questionwrapper>> getquizquestions(@PathVariable Integer id) {
		return quizservice.getquizquestions(id);

	}
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer>  submitquiz(@PathVariable Integer id,@RequestBody List<response>responses){
		 return quizservice.calculateresult(id,responses);
	
	}
	
	
}
