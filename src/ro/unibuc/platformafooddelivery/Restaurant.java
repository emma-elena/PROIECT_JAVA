package ro.unibuc.platformafooddelivery;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;

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