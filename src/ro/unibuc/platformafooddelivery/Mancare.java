package ro.unibuc.platformafooddelivery;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class Mancare {
    @NotNull
    private String denumireMancare;
    private int numarCalorii;
    private String reteta;

    public Mancare(@NotNull String denumireMancare, int numarCalorii) {
        this.denumireMancare = denumireMancare;
        this.numarCalorii = numarCalorii;
    }

    public int getnumarCalorii() {
        return numarCalorii;
    }

    public String getdenumireMancare() {
        return denumireMancare;
    }

    @Override
    public String toString() {
        return "Mancare{" +
                "denumireMancare='" + denumireMancare + '\'' +
                ", numarCalorii=" + numarCalorii + '\'' + '}';
    }

}