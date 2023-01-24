package bada_project.SpringApplication.model;

import java.util.Date;

public class Track {
    private int nr_nagrania;
    private String album;
    private String licencja;
    private Date waznosc_licencji;
    private String czas_trwania;
    private String tytul;
    private int nr_rozglosni;

    public Track(){

    }

    public Track(int nr_nagrania, String album, String licencja, Date waznosc_licencji, String czas_trwania, String tytul, int nr_rozglosni) {
        this.nr_nagrania = nr_nagrania;
        this.album = album;
        this.licencja = licencja;
        this.waznosc_licencji = waznosc_licencji;
        this.czas_trwania = czas_trwania;
        this.tytul = tytul;
        this.nr_rozglosni = nr_rozglosni;
    }
    public Track(int nr_nagrania, String album, String licencja, Date waznosc_licencji) {
        this.nr_nagrania = nr_nagrania;
        this.album = album;
        this.licencja = licencja;
        this.waznosc_licencji = waznosc_licencji;
    }

    public int getNr_nagrania() {
        return nr_nagrania;
    }

    public void setNr_nagrania(int nr_nagrania) {
        this.nr_nagrania = nr_nagrania;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getLicencja() {
        return licencja;
    }

    public void setLicencja(String licencja) {
        this.licencja = licencja;
    }

    public Date getWaznosc_licencji() {
        return waznosc_licencji;
    }

    public void setWaznosc_licencji(Date waznosc_licencji) {
        this.waznosc_licencji = waznosc_licencji;
    }

    public String getCzas_trwania() {
        return czas_trwania;
    }

    public void setCzas_trwania(String czas_trwania) {
        this.czas_trwania = czas_trwania;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public int getNr_rozglosni() {
        return nr_rozglosni;
    }

    public void setNr_rozglosni(int nr_rozglosni) {
        this.nr_rozglosni = nr_rozglosni;
    }


    @Override
    public String toString() {
        return "Utwor{" +
                "nr_nagrania=" + nr_nagrania +
                ", album='" + album + '\'' +
                ", licencja=" + licencja +
                ", waznosc_licencji=" + waznosc_licencji +
                ", czas_trwania=" + czas_trwania +
                ", tytul='" + tytul + '\'' +
                ", nr_rozglosni=" + nr_rozglosni +
                '}';
    }
}
