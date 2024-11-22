package com.example.cfs2.servlet.beans;

public class Manga {
    private String titolo;
    private String url;
    private Mangaka mangaka;
    private Generi genere;

   
    public Manga() {
        this.titolo = titolo;
        this.url = url;
    }
    
    public Manga(String titolo, String url) {
        this.titolo = titolo;
        this.url = url;
    }
    public Manga(String titolo, String url, Mangaka mangaka) {
        this.titolo = titolo;
        this.url = url;
        this.mangaka = mangaka;
    }
    public Manga(String titolo, String url, Mangaka mangaka, Generi genere) {
        this.titolo = titolo;
        this.url = url;
        this.mangaka = mangaka;
        this.genere=genere;
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
    
    public Mangaka getMangaka() {
    	return mangaka;
    }
    
    public void setMangaka(Mangaka mangaka) {
    	this.mangaka = mangaka;
    }
    
    public Generi getGenere() {
    	return genere;
    }
    
    public void setGenere(Generi genere) {
    	this.genere = genere;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "titolo='" + titolo + '\'' +
                ", URL='" + url + '\'' +
                '}';
    }
}
