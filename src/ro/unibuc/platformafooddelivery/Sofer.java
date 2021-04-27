package ro.unibuc.platformafooddelivery;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class Sofer extends Utilizator {

    public Sofer(@NotNull String userName, Date dataNasterii, String adresa) {
        super(userName, dataNasterii, adresa);
    }
}
