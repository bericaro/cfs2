package com.example.cfs2.servlet.beans;

public class Manga {
    private String titolo;
    private String url;

   
    public Manga() {
        this.titolo = titolo;
        this.url = url;
    }
    
    public Manga(String titolo, String url) {
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
        return "Manga{" +
                "titolo='" + titolo + '\'' +
                ", URL='" + url + '\'' +
                '}';
    }
}
