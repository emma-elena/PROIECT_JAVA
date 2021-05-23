package ro.unibuc.platformafooddelivery;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class Bautura {
    @NotNull
    protected String denumireBautura;

    public Bautura(@NotNull String denumireBautura) {
        this.denumireBautura = denumireBautura;
    }

    public String getdenumireBautura() {
        return denumireBautura;
    }

    @Override
    public String toString() {
        return "Bautura{" +
                "denumireBautura='" + denumireBautura + '\'' +'}';
    }

}