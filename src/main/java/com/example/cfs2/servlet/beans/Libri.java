package com.example.cfs2.servlet.beans;

public class Libri {
	private String titolo;
	private String url;
	private Scrittori scrittore;
	private Generi genere;

	public Libri() {
		this.titolo = titolo;
		this.url = url;
	}

	public Libri(String titolo, String url, Scrittori scrittore, Generi genere) {
		this.titolo = titolo;
		this.url = url;
		this.scrittore = scrittore;
		this.genere = genere;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Scrittori getScrittore() {
		return scrittore;
	}

	public void setScrittore(Scrittori scrittore) {
		this.scrittore = scrittore;
	}

	public Generi getGenere() {
		return genere;
	}

	public void setGenere(Generi genere) {
		this.genere = genere;
	}
	
	@Override
	public String toString() {
		return titolo + " " + scrittore + " " + " " + genere ;
	}
}
