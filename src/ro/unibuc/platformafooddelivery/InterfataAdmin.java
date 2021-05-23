package ro.unibuc.platformafooddelivery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner; //citeste -> vine de la scann

//Aici declar ce voi implementa in Actiuni.java
public interface InterfataAdmin {

    Utilizator getUtilizatorById(int id);

    Comanda getComandaById(int id);

    Restaurant getRestaurantById(int id);

    ArrayList<Comanda> comenzi = new ArrayList<>();
    ArrayList<Restaurant> restaurante = new ArrayList<>();
    ArrayList<Utilizator> utilizatori = new ArrayList<>();
    ArrayList<Sofer> sofer = new ArrayList<>();

    void adaugaComanda(Scanner in);

    void adaugaRestaurant(Scanner in);

    void adaugaUtilizator(Scanner in);

    void adaugaSofer(Scanner in);


    default Date parseDate(Scanner in) {
        try {
            String date = in.next();
            //parsarea datei
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

}

