package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.question;
import com.example.demo.service.questionservice;


@RestController
@RequestMapping("question")
public class questioncontroller {
	@Autowired
	public questionservice questionservice;
	
	@GetMapping("allquestions")
	public ResponseEntity< List<question> >getallquestions() {
		return questionservice.getallquestions();
		
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity< List<question>> getquestionbycategory(@PathVariable String category) {
		return questionservice.getquestionbycategory(category);
	}
	@PostMapping("add")
	public ResponseEntity <String>addquestion(@RequestBody question question) {
		return questionservice.addquestion(question);
	}

}
