package ro.unibuc.platformafooddelivery;

import org.jetbrains.annotations.NotNull;

public class Restaurant {

    @NotNull
    protected String nume;
    protected String adresa;
    protected String numarDeTelefon;
    protected final int id;
    private static int  contor = 0;

    public Restaurant(@NotNull String nume, String adresa, String numarDeTelefon) {
        this.nume = nume;
        this.adresa = adresa;
        this.numarDeTelefon = numarDeTelefon;
        contor++;
        this.id = contor;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getNumarDeTelefon() {
        return numarDeTelefon;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setNumarDeTelefon(String numarDeTelefon) {
        this.numarDeTelefon = numarDeTelefon;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", numarDeTelefon='" + numarDeTelefon + '\'' +
                ", id=" + id +
                '}';
    }
}
