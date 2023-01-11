package bada_project.SpringApplication.model;

import java.util.Date;

public class Rozglosnia {

    private int nr_rozglosni;
    private String nazwa;
    private Date data_zalozenia;
    private int nr_adresu;

    public Rozglosnia(){

    }

    public Rozglosnia(int nr_rozglosni, String nazwa, Date data_zalozenia, int nr_adresu) {
        super();
        this.nr_rozglosni = nr_rozglosni;
        this.nazwa = nazwa;
        this.data_zalozenia = data_zalozenia;
        this.nr_adresu = nr_adresu;
    }

    public int getNr_rozglosni() {
        return nr_rozglosni;
    }

    public void setNr_rozglosni(int nr_rozglosni) {
        this.nr_rozglosni = nr_rozglosni;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Date getData_zalozenia() {
        return data_zalozenia;
    }

    public void setData_zalozenia(Date data_zalozenia) {
        this.data_zalozenia = data_zalozenia;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    @Override
    public String toString() {
        return "Rozglosnia{" +
                "nr_rozglosni=" + nr_rozglosni +
                ", nazwa='" + nazwa + '\'' +
                ", data_zalozenia=" + data_zalozenia +
                ", nr_adresu=" + nr_adresu +
                '}';
    }
}
