package bada_project.SpringApplication.database;

import java.util.Date;

public class Autor {
    private int nr_autora;
    private String nazwa;
    private Date debiut;
    private String wytwornia;
    private int liczba_czlonkow;
    private int nr_rozglosni;

    public Autor(){

    }

    public Autor(int nr_autora, String nazwa, Date debiut, String wytwornia, int liczba_czlonkow, int nr_rozglosni) {
        this.nr_autora = nr_autora;
        this.nazwa = nazwa;
        this.debiut = debiut;
        this.wytwornia = wytwornia;
        this.liczba_czlonkow = liczba_czlonkow;
        this.nr_rozglosni = nr_rozglosni;
    }

    public int getNr_autora() {
        return nr_autora;
    }

    public void setNr_autora(int nr_autora) {
        this.nr_autora = nr_autora;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Date getDebiut() {
        return debiut;
    }

    public void setDebiut(Date debiut) {
        this.debiut = debiut;
    }

    public String getWytwornia() {
        return wytwornia;
    }

    public void setWytwornia(String wytwornia) {
        this.wytwornia = wytwornia;
    }

    public int getLiczba_czlonkow() {
        return liczba_czlonkow;
    }

    public void setLiczba_czlonkow(int liczba_czlonkow) {
        this.liczba_czlonkow = liczba_czlonkow;
    }

    public int getNr_rozglosni() {
        return nr_rozglosni;
    }

    public void setNr_rozglosni(int nr_rozglosni) {
        this.nr_rozglosni = nr_rozglosni;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nr_autora=" + nr_autora +
                ", nazwa='" + nazwa + '\'' +
                ", debiut=" + debiut +
                ", wytwornia='" + wytwornia + '\'' +
                ", liczba_czlonkow=" + liczba_czlonkow +
                ", nr_rozglosni=" + nr_rozglosni +
                '}';
    }
}
