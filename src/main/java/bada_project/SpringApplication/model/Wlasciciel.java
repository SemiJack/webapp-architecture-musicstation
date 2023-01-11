package bada_project.SpringApplication.model;

public class Wlasciciel {
    private int nr_wlasciciela;
    private String imie;
    private String nazwisko;
    private int nr_adresu;

    public Wlasciciel(){

    }

    public Wlasciciel(int nr_wlasciciela, String imie, String nazwisko, int nr_adresu) {
        this.nr_wlasciciela = nr_wlasciciela;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_adresu = nr_adresu;
    }

    public int getNr_wlasciciela() {
        return nr_wlasciciela;
    }

    public void setNr_wlasciciela(int nr_wlasciciela) {
        this.nr_wlasciciela = nr_wlasciciela;
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

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    @Override
    public String toString() {
        return "Wlasciciel{" +
                "nr_wlasciciela=" + nr_wlasciciela +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", nr_adresu=" + nr_adresu +
                '}';
    }
}
