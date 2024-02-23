package com.example.demo.service.to;

import java.io.Serializable;

public class UsuarioTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String password;
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UsuarioTO [name=" + name + ", password=" + password + "]";
	}
	
	

}
