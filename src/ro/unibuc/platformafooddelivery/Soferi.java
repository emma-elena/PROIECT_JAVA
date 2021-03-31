package ro.unibuc.platformafooddelivery;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class Soferi extends Utilizatori {

    public Soferi(@NotNull String userName, Date dataNasterii, String adress) {
        super(userName, dataNasterii, adress);
    }
}
