package bada_project.SpringApplication.model;

public class Reklamodawca {
    private int nr_reklamodawcy;
    private String nazwa_firmy;
    private String nr_telefonu;
    private String email;
    private String imie;
    private String nazwisko;

    public Reklamodawca(){

    }

    public Reklamodawca(int nr_reklamodawcy, String nazwa_firmy, String nr_telefonu, String email, String imie, String nazwisko) {
        this.nr_reklamodawcy = nr_reklamodawcy;
        this.nazwa_firmy = nazwa_firmy;
        this.nr_telefonu = nr_telefonu;
        this.email = email;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public int getNr_reklamodawcy() {
        return nr_reklamodawcy;
    }

    public void setNr_reklamodawcy(int nr_reklamodawcy) {
        this.nr_reklamodawcy = nr_reklamodawcy;
    }

    public String getNazwa_firmy() {
        return nazwa_firmy;
    }

    public void setNazwa_firmy(String nazwa_firmy) {
        this.nazwa_firmy = nazwa_firmy;
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Reklamodawca{" +
                "nr_reklamodawcy=" + nr_reklamodawcy +
                ", nazwa_firmy='" + nazwa_firmy + '\'' +
                ", nr_telefonu='" + nr_telefonu + '\'' +
                ", email='" + email + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
    }
}
