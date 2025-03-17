package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Repository;

import com.example.demo.model.quiz;
@Repository
@Table("quiz")
public interface quizdao extends JpaRepository<quiz, Integer>{

}
