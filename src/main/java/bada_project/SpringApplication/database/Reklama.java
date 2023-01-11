package bada_project.SpringApplication.database;

import java.util.Date;

public class Reklama {
    private int nr_nagrania;
    private String transkrypt;
    private Date data_od;
    private Date data_do;
    private double cena;
    private int odtworzenia;
    private int nr_reklamodawcy;

    public Reklama(){

    }

    public Reklama(int nr_nagrania, String transkrypt, Date data_od, Date data_do, double cena, int odtworzenia, int nr_reklamodawcy) {
        this.nr_nagrania = nr_nagrania;
        this.transkrypt = transkrypt;
        this.data_od = data_od;
        this.data_do = data_do;
        this.cena = cena;
        this.odtworzenia = odtworzenia;
        this.nr_reklamodawcy = nr_reklamodawcy;
    }

    public int getNr_nagrania() {
        return nr_nagrania;
    }

    public void setNr_nagrania(int nr_nagrania) {
        this.nr_nagrania = nr_nagrania;
    }

    public String getTranskrypt() {
        return transkrypt;
    }

    public void setTranskrypt(String transkrypt) {
        this.transkrypt = transkrypt;
    }

    public Date getData_od() {
        return data_od;
    }

    public void setData_od(Date data_od) {
        this.data_od = data_od;
    }

    public Date getData_do() {
        return data_do;
    }

    public void setData_do(Date data_do) {
        this.data_do = data_do;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getOdtworzenia() {
        return odtworzenia;
    }

    public void setOdtworzenia(int odtworzenia) {
        this.odtworzenia = odtworzenia;
    }

    public int getNr_reklamodawcy() {
        return nr_reklamodawcy;
    }

    public void setNr_reklamodawcy(int nr_reklamodawcy) {
        this.nr_reklamodawcy = nr_reklamodawcy;
    }

    @Override
    public String toString() {
        return "Reklama{" +
                "nr_nagrania=" + nr_nagrania +
                ", transkrypt='" + transkrypt + '\'' +
                ", data_od=" + data_od +
                ", data_do=" + data_do +
                ", cena=" + cena +
                ", odtworzenia=" + odtworzenia +
                ", nr_reklamodawcy=" + nr_reklamodawcy +
                '}';
    }
}
