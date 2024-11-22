package com.example.cfs2.servlet.beans;

public class Mangaka {
	private String nome;
	private String cognome;
	private Manga manga;

	public Mangaka() {
		this.nome = nome;
		this.cognome = cognome;
		this.manga = manga;
	}

	public Mangaka(String nome, String cognome, Manga manga) {
		this.nome = nome;
		this.cognome = cognome;
		this.manga = manga;
	}

	public Mangaka(String nome, String cognome) {
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
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Manga getManga() {
		return manga;
	}

	public void setManga(Manga manga) {
		this.manga = manga;
	}

	@Override
	public String toString() {
		if (cognome == null) {
			return nome;
		} else {
			return nome + " " + cognome;
		}
	}
}
