package bada_project.SpringApplication.model;

public class Recording {
    private int nr_nagrania;
    private String czas_trwania;
    private String tytul;
    private int nr_rozglosni;

    public Recording(){

    }

    public Recording(int nr_nagrania, String czas_trwania, String tytul, int nr_rozglosni) {
        this.nr_nagrania = nr_nagrania;
        this.czas_trwania = czas_trwania;
        this.tytul = tytul;
        this.nr_rozglosni = nr_rozglosni;
    }

    public int getNr_nagrania() {
        return nr_nagrania;
    }

    public void setNr_nagrania(int nr_nagrania) {
        this.nr_nagrania = nr_nagrania;
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
        return "Nagranie{" +
                "nr_nagrania=" + nr_nagrania +
                ", czas_trwania=" + czas_trwania +
                ", tytul='" + tytul + '\'' +
                ", nr_rozglosni=" + nr_rozglosni +
                '}';
    }
}
