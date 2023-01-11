package bada_project.SpringApplication.model;

import java.util.Date;

public class Reporter {
    private String prawo_jazdy;
    private Date waznosc_prawa_jazdy;
    private boolean legitymacja_prasowa;
    private Date waznosc_legit_prasowej;
    private int nr_pracownika;

    public Reporter(){

    }

    public Reporter(String prawo_jazdy, Date waznosc_prawa_jazdy, boolean legitymacja_prasowa, Date waznosc_legit_prasowej, int nr_pracownika) {
        this.prawo_jazdy = prawo_jazdy;
        this.waznosc_prawa_jazdy = waznosc_prawa_jazdy;
        this.legitymacja_prasowa = legitymacja_prasowa;
        this.waznosc_legit_prasowej = waznosc_legit_prasowej;
        this.nr_pracownika = nr_pracownika;
    }

    public String getPrawo_jazdy() {
        return prawo_jazdy;
    }

    public void setPrawo_jazdy(String prawo_jazdy) {
        this.prawo_jazdy = prawo_jazdy;
    }

    public Date getWaznosc_prawa_jazdy() {
        return waznosc_prawa_jazdy;
    }

    public void setWaznosc_prawa_jazdy(Date waznosc_prawa_jazdy) {
        this.waznosc_prawa_jazdy = waznosc_prawa_jazdy;
    }

    public boolean isLegitymacja_prasowa() {
        return legitymacja_prasowa;
    }

    public void setLegitymacja_prasowa(boolean legitymacja_prasowa) {
        this.legitymacja_prasowa = legitymacja_prasowa;
    }

    public Date getWaznosc_legit_prasowej() {
        return waznosc_legit_prasowej;
    }

    public void setWaznosc_legit_prasowej(Date waznosc_legit_prasowej) {
        this.waznosc_legit_prasowej = waznosc_legit_prasowej;
    }

    public int getNr_pracownika() {
        return nr_pracownika;
    }

    public void setNr_pracownika(int nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
    }

    @Override
    public String toString() {
        return "Reporter{" +
                "prawo_jazdy='" + prawo_jazdy + '\'' +
                ", waznosc_prawa_jazdy=" + waznosc_prawa_jazdy +
                ", legitymacja_prasowa=" + legitymacja_prasowa +
                ", waznosc_legit_prasowej=" + waznosc_legit_prasowej +
                ", nr_pracownika=" + nr_pracownika +
                '}';
    }
}
