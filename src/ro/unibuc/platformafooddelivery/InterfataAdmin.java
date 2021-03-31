package ro.unibuc.platformafooddelivery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner; //citeste -> vine de la scann

//Aici declar ce voi implementa in Actiuni.java
public interface InterfataAdmin {

    Utilizatori getUtilizatoriById(int id);
    Comenzi getComenziById(int id);
    Restaurant getRestaurantById(int id);

    ArrayList<Comenzi> comenzi = new ArrayList<>();
    ArrayList<Restaurant> restaurante = new ArrayList<>();
    ArrayList<Utilizatori> utilizatori = new ArrayList<>();
    ArrayList<Soferi> soferi = new ArrayList<>();

    void adaugaComenzi(Scanner in);
    void adaugaRestaurant(Scanner in);
    void adaugaUtilizatori(Scanner in);
    void adaugaSoferi(Scanner in);


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
