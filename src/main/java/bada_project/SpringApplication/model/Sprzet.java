package bada_project.SpringApplication.model;

public class Sprzet {
    private int nr_sprzetu;
    private String nazwa;
    private String nazwa_szegol;
    private double cena;
    private int nr_rozglosni;

    public Sprzet(){

    }

    public Sprzet(int nr_sprzetu, String nazwa, String nazwa_szegol, double cena, int nr_rozglosni) {
        this.nr_sprzetu = nr_sprzetu;
        this.nazwa = nazwa;
        this.nazwa_szegol = nazwa_szegol;
        this.cena = cena;
        this.nr_rozglosni = nr_rozglosni;
    }

    public int getNr_sprzetu() {
        return nr_sprzetu;
    }

    public void setNr_sprzetu(int nr_sprzetu) {
        this.nr_sprzetu = nr_sprzetu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa_szegol() {
        return nazwa_szegol;
    }

    public void setNazwa_szegol(String nazwa_szegol) {
        this.nazwa_szegol = nazwa_szegol;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getNr_rozglosni() {
        return nr_rozglosni;
    }

    public void setNr_rozglosni(int nr_rozglosni) {
        this.nr_rozglosni = nr_rozglosni;
    }

    @Override
    public String toString() {
        return "Sprzet{" +
                "nr_sprzetu=" + nr_sprzetu +
                ", nazwa='" + nazwa + '\'' +
                ", nazwa_szegol='" + nazwa_szegol + '\'' +
                ", cena=" + cena +
                ", nr_rozglosni=" + nr_rozglosni +
                '}';
    }
}
