package bada_project.SpringApplication.model;

public class Gosc {
    private int nr_goscia;
    private String imie;
    private String nazwisko;
    private String pseudonim;
    private String email;
    private int nr_telefonu;
    private int nr_rozglosni;

    public Gosc(){

    }

    public Gosc(int nr_goscia, String imie, String nazwisko, String pseudonim, String email, int nr_telefonu, int nr_rozglosni) {
        this.nr_goscia = nr_goscia;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pseudonim = pseudonim;
        this.email = email;
        this.nr_telefonu = nr_telefonu;
        this.nr_rozglosni = nr_rozglosni;
    }

    public int getNr_goscia() {
        return nr_goscia;
    }

    public void setNr_goscia(int nr_goscia) {
        this.nr_goscia = nr_goscia;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPseudonim() {
        return pseudonim;
    }

    public void setPseudonim(String pseudonim) {
        this.pseudonim = pseudonim;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(int nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    public int getNr_rozglosni() {
        return nr_rozglosni;
    }

    public void setNr_rozglosni(int nr_rozglosni) {
        this.nr_rozglosni = nr_rozglosni;
    }

    @Override
    public String toString() {
        return "Gosc{" +
                "nr_goscia=" + nr_goscia +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pseudonim='" + pseudonim + '\'' +
                ", email='" + email + '\'' +
                ", nr_telefonu=" + nr_telefonu +
                ", nr_rozglosni=" + nr_rozglosni +
                '}';
    }
}
