package bada_project.SpringApplication.model;

import oracle.sql.CHAR;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Employee {
    private int nr_pracownika;
    private String imie;
    private String nazwisko;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data_urodzenia;
    private String pesel;
    private String plec;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data_zatrudnienia;
    private String nr_konta;
    private String email;
    private String nr_telefonu;
    private int nr_rozglosni;
    private int nr_adresu;
    private int nr_stanowiska;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime lokalnaData_urodzenia;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime lokalnaData_zatrudnienia;
    public Employee(){

    }

    public Employee(int nr_pracownika, String imie, String nazwisko, Date data_urodzenia, String pesel, String plec, Date data_zatrudnienia, String nr_konta, String email, String nr_telefonu, int nr_rozglosni, int nr_adresu, int nr_stanowiska) {
        this.nr_pracownika = nr_pracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.pesel = pesel;
        this.plec = plec;
        this.data_zatrudnienia = data_zatrudnienia;
        this.nr_konta = nr_konta;
        this.email = email;
        this.nr_telefonu = nr_telefonu;
        this.nr_rozglosni = nr_rozglosni;
        this.nr_adresu = nr_adresu;
        this.nr_stanowiska = nr_stanowiska;
    }

    public int getNr_pracownika() {
        return nr_pracownika;
    }

    public void setNr_pracownika(int nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
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

    public Date getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(Date data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public LocalDateTime getLokalnaData_urodzenia() {
        try {
            lokalnaData_urodzenia = new java.sql.Timestamp(this.data_urodzenia.getTime()).toLocalDateTime();
        }catch(NullPointerException npe){
            return null;
        }
        return lokalnaData_urodzenia;
    }

    public void setLokalnaData_urodzenia(LocalDateTime dateTime){
        this.data_urodzenia = java.sql.Timestamp.valueOf(dateTime);
    }

    public LocalDateTime getLokalnaData_zatrudnienia() {
        try {
            lokalnaData_zatrudnienia = new java.sql.Timestamp(this.data_zatrudnienia.getTime()).toLocalDateTime();
        }catch(NullPointerException npe){
            return null;
        }
        return lokalnaData_zatrudnienia;
    }

    public void setLokalnaData_zatrudnienia(LocalDateTime dateTime){
        this.data_zatrudnienia = java.sql.Timestamp.valueOf(dateTime);
    }
    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public Date getData_zatrudnienia() {
        return data_zatrudnienia;
    }

    public void setData_zatrudnienia(Date data_zatrudnienia) {
        this.data_zatrudnienia = data_zatrudnienia;
    }

    public String getNr_konta() {
        return nr_konta;
    }

    public void setNr_konta(String nr_konta) {
        this.nr_konta = nr_konta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    public int getNr_rozglosni() {
        return nr_rozglosni;
    }

    public void setNr_rozglosni(int nr_rozglosni) {
        this.nr_rozglosni = nr_rozglosni;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    public int getNr_stanowiska() {
        return nr_stanowiska;
    }

    public void setNr_stanowiska(int nr_stanowiska) {
        this.nr_stanowiska = nr_stanowiska;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "nr_pracownika=" + nr_pracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", data_urodzenia=" + data_urodzenia +
                ", pesel='" + pesel + '\'' +
                ", plec='" + plec + '\'' +
                ", data_zatrudnienia=" + data_zatrudnienia +
                ", nr_konta='" + nr_konta + '\'' +
                ", email='" + email + '\'' +
                ", nr_telefonu='" + nr_telefonu + '\'' +
                ", nr_rozglosni=" + nr_rozglosni +
                ", nr_adresu=" + nr_adresu +
                ", nr_stanowiska=" + nr_stanowiska +
                '}';
    }
}
