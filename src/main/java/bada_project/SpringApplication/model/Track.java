package bada_project.SpringApplication.model;

import java.util.Date;

public class Track {
    private int nr_nagrania;
    private String album;
    private String licencja;
    private Date waznosc_licencji;

    public Track(){

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

    @Override
    public String toString() {
        return "Utwor{" +
                "nr_nagrania=" + nr_nagrania +
                ", album='" + album + '\'' +
                ", licencja=" + licencja +
                ", waznosc_licencji=" + waznosc_licencji +
                '}';
    }
}
