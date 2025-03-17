package com.example.demo.model;

import org.antlr.v4.runtime.misc.NotNull;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class response {

	private Integer id;
	@NotNull
	private String response;
	
	public response(Integer id, String response) {
		super();
		this.id = id;
		this.response = response;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "response [id=" + id + ", response=" + response + "]";
	}
	
	
	
}
