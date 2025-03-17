package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dao.questiondao;
import com.example.demo.dao.quizdao;
import com.example.demo.model.question;
import com.example.demo.model.questionwrapper;
import com.example.demo.model.quiz;
import com.example.demo.model.response;

@Service
public class quizservice {

	@Autowired
	quizdao quizdao;
	@Autowired
    questiondao questiondao;

	
	public ResponseEntity<String> createquiz(String category, int numq, String title) {
		List<question> question = questiondao.findrandomquestionBycategory(category, numq);
		quiz quiz=new quiz();
		quiz.setTitle(title);
		quiz.setQuestion(question);
		quizdao.save(quiz);
		return new ResponseEntity<>("success", HttpStatus.CREATED);
	}
		
	


	public ResponseEntity<List<questionwrapper>> getquizquestions(Integer id) {
		Optional<quiz> quiz = quizdao.findById(id);
		List<question> questionfromdb = quiz.get().getQuestion();
		List<questionwrapper> questionforuser = new ArrayList<>();
		for (question q : questionfromdb) {
			questionwrapper qw = new questionwrapper(q.getId(), q.getQuestiontitle(), q.getOption1(), q.getOption2(),
					q.getOption3(), q.getOption4());
			questionforuser.add(qw);
		}
		return new ResponseEntity<>(questionforuser, HttpStatus.OK);
	}

	 public ResponseEntity<Integer> calculateresult(Integer id, List<response> responses) {
	        quiz quiz = quizdao.findById(id).get();
	        List<question> questions = quiz.getQuestion();
	        int right = 0;
	        int i = 0;
	        for(response response : responses){
	        	 if (response != null && response.getResponse() != null) {
	            if(response.getResponse().equals(questions.get(i).getRightanswer()))
	                right++;

	            i++;
	        }
	       
	    }
			return new ResponseEntity<>(right, HttpStatus.OK);
}
}


