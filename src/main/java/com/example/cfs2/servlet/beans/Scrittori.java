package com.example.cfs2.servlet.beans;

public class Scrittori {
private String nome;
private String cognome;
private Libri libro;

public Scrittori() {
	this.nome = nome;
	this.cognome = cognome;
	this.libro=libro;
}
public Scrittori(String nome, String cognome, Libri libro) {
	this.nome = nome;
	this.cognome = cognome;
	this.libro=libro;
}

public Scrittori(String nome, String cognome) {
	this.nome = nome;
	this.cognome = cognome;
}

public String getNome() {
	return nome;
}
public String getCognome() {
	return cognome;
}
public void setNome(String nome) {
	this.nome=nome;
}
public void setCognome(String cognome) {
	this.cognome=cognome;
}

public Libri getLibro() {
	return libro;
}
public void setLibro(Libri libro) {
	this.libro = libro;
}

@Override
public String toString() {
	if(cognome == null) {
		return nome;
	}else {
    return nome + " "+ cognome;
	}
}
}
