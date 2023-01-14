package bada_project.SpringApplication.model;


import java.util.Date;

public class Broadcast {
    private int nr_audycji;
    private Date data;
    private String format;
    private String czas_trwania;
    private int nr_rozglosni;

    public Broadcast(){

    }

    public Broadcast(int nr_audycji, Date data, String format, String czas_trwania, int nr_rozglosni) {
        this.nr_audycji = nr_audycji;
        this.data = data;
        this.format = format;
        this.czas_trwania = czas_trwania;
        this.nr_rozglosni = nr_rozglosni;
    }

    public int getNr_audycji() {
        return nr_audycji;
    }

    public void setNr_audycji(int nr_audycji) {
        this.nr_audycji = nr_audycji;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getCzas_trwania() {
        return czas_trwania;
    }

    public void setCzas_trwania(String czas_trwania) {
        this.czas_trwania = czas_trwania;
    }

    public int getNr_rozglosni() {
        return nr_rozglosni;
    }

    public void setNr_rozglosni(int nr_rozglosni) {
        this.nr_rozglosni = nr_rozglosni;
    }

    @Override
    public String toString() {
        return "Audycja{" +
                "nr_audycji=" + nr_audycji +
                ", data=" + data +
                ", format='" + format + '\'' +
                ", czas_trwania=" + czas_trwania +
                ", nr_rozglosni=" + nr_rozglosni +
                '}';
    }
}
