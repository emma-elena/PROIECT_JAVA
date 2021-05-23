package ro.unibuc.platformafooddelivery;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class Supermarket {
    @NotNull
    private String denumireSupermarket;
    private String produs;

    public Supermarket (@NotNull String denumireMancare, int numarCalorii) {
        this.denumireSupermarket = denumireSupermarket;
        this.produs = produs;
    }

    public String denumireSupermarket() {
        return denumireSupermarket;
    }

    @Override
    public String toString() {
        return "Mancare{" +
                "denumireMancare='" + denumireSupermarket + '\'' +
                ", produs=" + produs + '\'' + '}';
    }

}