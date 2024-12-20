package com.example.cfs2.servlet.beans;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.annotation.Resource;

public class Utenti {
	private String email;
	private String password;
	private String name;
	private String surname;
	private Date birth;
	
	public Utenti() {
		this.email=email;
		this.password=password;
	}

	public Utenti(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public Utenti(String name, String surname, String email, String password) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname=surname;
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
    
    public Date getBirth() {
    	return birth;
    }
    
    public void setBirth(Date birth) {
    	this.birth = birth;
    }

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", name=" + name + ", surname=" + surname
				+ ", birth=" + birth + "]";
	}
    

}
