package com.example.cfs2.servlet.beans;

public class SerieTv {
	private String titolo;
	private String url;
	private Generi genere;

	public SerieTv() {
		this.titolo = titolo;
		this.url = url;
		this.genere = genere;
	}

	public SerieTv(String titolo, String url) {
		this.titolo = titolo;
		this.url = url;
	}
	
	public SerieTv(String titolo, String url, Generi genere) {
		this.titolo = titolo;
		this.url = url;
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

    public Generi getGenere() {
    	return genere;
    }
    
    public void setGenere(Generi genere) {
    	this.genere = genere;
    }

	@Override
	public String toString() {
		return "Serie TV{" + "titolo='" + titolo + '\'' + ", URL='" + url + '\'' + '}';
	}
}
