package bada_project.SpringApplication.database;

public class Gatunek {
    private int nr_gatunku;
    private String nazwa;
    private int nr_rozglosni;

    public Gatunek(){

    }

    public Gatunek(int nr_gatunku, String nazwa, int nr_rozglosni) {
        this.nr_gatunku = nr_gatunku;
        this.nazwa = nazwa;
        this.nr_rozglosni = nr_rozglosni;
    }

    public int getNr_gatunku() {
        return nr_gatunku;
    }

    public void setNr_gatunku(int nr_gatunku) {
        this.nr_gatunku = nr_gatunku;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getNr_rozglosni() {
        return nr_rozglosni;
    }

    public void setNr_rozglosni(int nr_rozglosni) {
        this.nr_rozglosni = nr_rozglosni;
    }

    @Override
    public String toString() {
        return "Gatunek{" +
                "nr_gatunku=" + nr_gatunku +
                ", nazwa='" + nazwa + '\'' +
                ", nr_rozglosni=" + nr_rozglosni +
                '}';
    }
}
