package ro.unibuc.platformafooddelivery;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class Comanda {
    @NotNull
    private String restaurant;
    private String utilizatorul;
    private int idUtilizator;
    private String mancarea;
    private String bautura;
    private Date data;
    private final int id;
    private static int contor = 0;

    public Comanda(int id) {
        this.id = id;
    }

    public Comanda(@NotNull String restaurant, String utilizatorul,String mancarea,String bautura, Date data){
        this.restaurant = restaurant;
        this.utilizatorul = utilizatorul;
        this.mancarea = mancarea;
        this.bautura = bautura;
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

    public String getMancarea(){return mancarea;}

    public String getBautura(){return bautura;}

    public Date getData() {
        return data;
    }

    public int getId() {
        return id;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public void setUtilizatorul(String utilizatorul) {
        this.utilizatorul = utilizatorul;
    }

    public void setMancarea(String mancarea) {
        this.mancarea = mancarea;
    }

    public void setBautura(String bautura) {
        this.bautura = bautura;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getIdUtilizator() {
        return idUtilizator;
    }

    public void setIdUtilizator(int idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "restaurant='" + restaurant + '\'' +
                ", utilizatorul='" + utilizatorul + '\'' +
                ", mancare='" + mancarea + '\'' +
                ", bautura='" + bautura + '\'' +
                ", data=" + data +
                ", id=" + id +
                '}';
    }
}


