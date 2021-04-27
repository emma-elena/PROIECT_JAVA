package ro.unibuc.platformafooddelivery;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class Comanda {
    @NotNull
    protected final String restaurant;
    protected final String utilizatorul;
    protected final String sofer;
    protected final Date data;
    protected final int id;
    private static int contor = 0;

    public Comanda(@NotNull String restaurant, String utilizatorul, String sofer, Date data) {
        this.restaurant = restaurant;
        this.utilizatorul = utilizatorul;
        this.sofer = sofer;
        this.data = data;
        contor++;
        this.id = contor;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public String getUtilizatorul() {
        return utilizatorul;
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
        return "Comanda{" +
                "restaurant='" + restaurant + '\'' +
                ", utilizatorul='" + utilizatorul + '\'' +
                ", sofer='" + sofer + '\'' +
                ", data=" + data +
                ", id=" + id +
                '}';
    }
}

