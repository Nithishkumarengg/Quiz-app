package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Repository;

import com.example.demo.model.question;

import jakarta.annotation.Nonnull;
@Repository
@Nonnull
@Table("question")
public interface questiondao extends JpaRepository<question, Integer>{
	 
	List<question> findBycategory(String category);
@Query(value="SELECT * FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numq;",nativeQuery = true)
	List<question> findrandomquestionBycategory(String category, int numq);

}
