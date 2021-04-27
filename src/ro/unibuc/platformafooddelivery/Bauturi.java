package ro.unibuc.platformafooddelivery;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class Bauturi {
    @NotNull
    protected String denumireBautura;

    public Bauturi(@NotNull String denumireBautura) {
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
