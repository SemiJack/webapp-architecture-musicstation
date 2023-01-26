package bada_project.SpringApplication.model;

public class Jobposition {
    private int nr_stanowiska;
    private String nazwa;
    private String opis;

    public Jobposition(){

    }

    public Jobposition(int nr_stanowiska, String nazwa, String opis) {
        this.nr_stanowiska = nr_stanowiska;
        this.nazwa = nazwa;
        this.opis = opis;
    }

    public int getNr_stanowiska() {
        return nr_stanowiska;
    }

    public void setNr_stanowiska(int nr_stanowiska) {
        this.nr_stanowiska = nr_stanowiska;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "Jobposition{" +
                "nr_stanowiska=" + nr_stanowiska +
                ", nazwa='" + nazwa + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }
}
