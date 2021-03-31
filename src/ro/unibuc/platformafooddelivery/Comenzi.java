package ro.unibuc.platformafooddelivery;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class Comenzi {
    @NotNull
    protected final String restaurant;
    protected final String utilizator;
    protected final String sofer;
    protected final Date data;
    protected final int id;
    private static int contor = 0;

    public Comenzi(@NotNull String restaurant, String utilizator, String sofer, Date data) {
        this.restaurant = restaurant;
        this.utilizator = utilizator;
        this.sofer = sofer;
        this.data = data;
        contor++;
        this.id = contor;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public String getUtilizator() {
        return utilizator;
    }

    public String getSofer() {
        return sofer;
    }

    public Date getData() {
        return data;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Comenzi{" +
                "restaurant='" + restaurant + '\'' +
                ", utilizator='" + utilizator + '\'' +
                ", sofer='" + sofer + '\'' +
                ", data=" + data +
                ", id=" + id +
                '}';
    }
}
