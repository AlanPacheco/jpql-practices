package com.devsuperior.uri2602.dto;

import java.io.Serializable;

import com.devsuperior.uri2602.projections.CustomerMinProjection;

public class CustomerNameDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;

	public CustomerNameDTO() {
	}
	
	public CustomerNameDTO(String name) {
		this.name = name;
	}
	
	public CustomerNameDTO(CustomerMinProjection customerMinProjection) {
		this(customerMinProjection.getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
