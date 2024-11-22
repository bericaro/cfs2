package com.example.cfs2.servlet.beans;

public class Fumetti {
	private String titolo;
	private String url;
	private Disegnatori disegnatore;
	private Generi genere;

	public Fumetti() {
		this.titolo = titolo;
		this.url = url;
	}

	public Fumetti(String titolo, String url) {
		this.titolo = titolo;
		this.url = url;
	}
	public Fumetti(String titolo, String url, Disegnatori disegnatore, Generi genere) {
		this.titolo = titolo;
		this.url = url;
		this.disegnatore = disegnatore;
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
	
	public Disegnatori getDisegnatore() {
		return disegnatore;
	}

	public void setDisegnatore(Disegnatori disegnatore) {
		this.disegnatore = disegnatore;
	}
	
    public Generi getGenere() {
    	return genere;
    }
    
    public void setGenere(Generi genere) {
    	this.genere = genere;
    }

	@Override
	public String toString() {
		return "Fumetti{" + "titolo='" + titolo + '\'' + ", URL='" + url + '\'' + '}';
	}
}
