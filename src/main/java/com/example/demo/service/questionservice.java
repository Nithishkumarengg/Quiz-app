package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.questiondao;
import com.example.demo.model.question;
@Service
public class questionservice {
	@Autowired
public questiondao questiondao;
	
	public ResponseEntity< List<question>> getallquestions() {
		try {
		return new ResponseEntity<>( questiondao.findAll(),HttpStatus.OK);

}catch(Exception e){
	e.printStackTrace();
}
		return new ResponseEntity<>( new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public  ResponseEntity< List<question>> getquestionbycategory(String category) {
		try {
		return new ResponseEntity<List<question>>(questiondao.findBycategory(category),HttpStatus.OK);

}catch(Exception e){
	e.printStackTrace();
}
		return new ResponseEntity<>( new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
		
	
	

	public ResponseEntity<String> addquestion(question question) {
		questiondao.save(question);
		return new ResponseEntity<String>("sucess",HttpStatus.CREATED);
	}

	
}
