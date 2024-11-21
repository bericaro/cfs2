package com.example.cfs2.servlet.beans;

public class Fumetti {
	private String titolo;
	private String url;

	public Fumetti() {
		this.titolo = titolo;
		this.url = url;
	}

	public Fumetti(String titolo, String url) {
		this.titolo = titolo;
		this.url = url;
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

	@Override
	public String toString() {
		return "Fumetti{" + "titolo='" + titolo + '\'' + ", URL='" + url + '\'' + '}';
	}
}
