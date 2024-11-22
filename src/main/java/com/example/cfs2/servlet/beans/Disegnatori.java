package com.example.cfs2.servlet.beans;

public class Disegnatori {
	private String nome;
	private String cognome;
	private Fumetti fumetto;

	public Disegnatori() {
		this.nome = nome;
		this.cognome = cognome;
		this.fumetto = fumetto;
	}

	public Disegnatori(String nome, String cognome, Fumetti fumetto) {
		this.nome = nome;
		this.cognome = cognome;
		this.fumetto = fumetto;
	}

	public Disegnatori(String nome, String cognome) {
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

	public Fumetti getFumetti() {
		return fumetto;
	}

	public void setFumetti(Fumetti fumetto) {
		this.fumetto = fumetto;
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
