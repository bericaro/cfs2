package com.example.cfs2.servlet.beans;

import java.lang.reflect.Constructor;
import java.time.LocalDate;

import jakarta.annotation.Resource;

public class User {
	private String email;
	private String password;
	private String name;
	private String surname;
	private LocalDate birth;
	
	public User() {
		this.email=email;
		this.password=password;
	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
	 return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setName (String name) {
    	this.name = name;
    }
    
    public String getSurname () {
    	return surname;
    }
    
    public void setSurname(String surname) {
    	this.surname = surname;
    }
    
    public LocalDate getBirth() {
    	return birth;
    }
    
    public void setBirth(LocalDate birth) {
    	this.birth = birth;
    }

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", name=" + name + ", surname=" + surname
				+ ", birth=" + birth + "]";
	}
    

}