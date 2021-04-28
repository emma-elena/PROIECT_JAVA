package ro.unibuc.platformafooddelivery;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class Sofer extends Utilizator {
    private String nrTelefon;

    public Sofer(@NotNull String userName, Date dataNasterii, String adresa) {
        super(userName, dataNasterii, adresa);
        this.nrTelefon = nrTelefon;
    }


    public String getnrTelefon() {
        return nrTelefon;
    }

    public void setnrTelefon(@NotNull String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

}