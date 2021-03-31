package ro.unibuc.platformafooddelivery;

import java.util.Date;
import java.util.Scanner;

//Aici voi implementa ce am in InterfataAdmin
public class Actiuni  implements InterfataAdmin{

    @Override
    public Utilizatori getUtilizatoriById(int id){
        for(Utilizatori utilizator: utilizatori){
            if(utilizator.getId() == id)
                return utilizator;
        }
        return null;
    }

    @Override
    public Comenzi getComenziById(int id){
        for(Comenzi comanda: comenzi)
        {
            if(comanda.getId() == id)
                return comanda;
        }
        return null;
    }

    @Override
    public Restaurant getRestaurantById(int id){
        for(Restaurant restaurant: restaurante)
        {
            if(restaurant.getId() == id)
                return restaurant;
        }
        return null;
    }

    @Override
    public void adaugaComenzi(Scanner in){
        System.out.println("Introduceti numele restaurantului");
        String restaurant = in.next();

        System.out.println("Introduceti numele de utilizator");
        String utilizator = in.next();

        System.out.println("Introduceti numele soferului care preia comanda");
        String sofer = in.next();

        System.out.println("Introduceti data sub forma aaaa-ll-zz");
        Date data = parseDate(in);

        //aici o sa creezi noua comanda care o sa aiba particularitatile introduse mai sus
        Comenzi comanda = new Comenzi(restaurant, utilizator, sofer, data);
        comenzi.add(comanda); //aici o sa adaugi comanda in vectorul de comenzi
    }

    @Override
    public void adaugaRestaurant(Scanner in){
        System.out.println("Introduceti numele restaurantului");
        String nume = in.next();

        System.out.println("Introduceti adresa restaurantului");
        String adresa = in.next();

        System.out.println("Introduceti numarul de telefon");
        String numarDeTelefon = in.next();

        Restaurant restaurant = new Restaurant(nume, adresa, numarDeTelefon);
        restaurante.add(restaurant);
    }

    @Override
    public void adaugaUtilizatori(Scanner in){
        System.out.println("Introduceti numele de utilizator");
        String userName = in.next();

        System.out.println("Introduceti data de nastere");
        Date dataNasterii = parseDate(in);

        System.out.println("Introduceti adresa");
        String adresa = in.next();

        //Utilizatori acum a devenit un tip de declarare cum este bool, int, string, char etc,
        // poti declara un obiect de tip Utilizator
        Utilizatori utilizator = new Utilizatori(userName, dataNasterii, adresa);
        utilizatori.add(utilizator);
    }


    @Override
    public void adaugaSoferi(Scanner in){
        System.out.println("Introduceti numele soferului");
        String userName = in.next();

        System.out.println("Introduceti data nasterii");
        Date dataNasterii = parseDate(in);

        System.out.println("Introduceti adresa");
        String adresa = in.next();

        Soferi sofer = new Soferi(userName, dataNasterii, adresa);
        soferi.add(sofer);
    }

}
//Pe ecran: Introduceti numele restaurtului
//Trattoria
//  in.next() o sa citeasca "Trattoria "
//  String restaurant = in.next(); <=> restaurant = "Trattoria"


//id = 3
//COMENZI:

//Restaurant id=1 (String nume, String Adresa, String numarDeTelefon)
//Restaurant id=2 (String nume, String Adresa, String numarDeTelefon)
//Restaurant id=3 (String nume, String Adresa, String numarDeTelefon)
//Restaurant id=4 (String nume, String Adresa, String numarDeTelefon)

//k = 3;
//for(i=1;i<=n;i++)
//if(v[i]==k)