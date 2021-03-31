package ro.unibuc.platformafooddelivery;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Actiuni actiuni = new Actiuni();
        System.out.println("Pentru a iesi din meniu va rugam apasati -1");
        System.out.println("Pentru a adauga un utilizator nou apasati 1");
        System.out.println("Pentru a adauga un sofer nou apasati 2");
        System.out.println("Pentru a adauga o comanda apasati 3");
        System.out.println("Pentru a adauga un restaurant apasati 4");
        System.out.println("Pentru a vedea o comanda apasati 5");
        System.out.println("Pentru a vedea datele unui utilizator apasati 6");
        System.out.println("Pentru a vedea care sunt toate comenzile apasati 7");
        System.out.println("Pentru a vedea care sunt toate restaurantele apasati 8");
        System.out.println("Pentru a vedea toti utilizatorii apasati 9");
        System.out.println("Pentru a vedea un detalii despre un restaurant apasati 10");
        int alegere = in.nextInt();
        //Pentru a iesi din meniu apasati -1
        while (alegere > 0){
            try {
                if ( alegere == 1){
                    actiuni.adaugaUtilizatori(in);
                }
                else if (alegere == 2){
                    actiuni.adaugaSoferi(in);
                }
                else if (alegere == 3)
                {
                    actiuni.adaugaComenzi(in);
                }
                else if ( alegere == 4)
                {
                    actiuni.adaugaRestaurant(in);
                }
                else if ( alegere == 5){
                    System.out.println("Introduceti ID-ul comenzii pentru care doriti sa vedeti detalii");
                    System.out.println(actiuni.getComenziById(in.nextInt()).toString());
                }
                else if ( alegere == 6)
                {
                    System.out.println("Introduceti ID-ul utilizatorului pentru care doriti detalii");
                    System.out.println(actiuni.getUtilizatoriById(in.nextInt()).toString());
                }
                else if (alegere == 7)
                {
                    System.out.println(InterfataAdmin.comenzi.toString());
                }
                else if (alegere==8){
                    System.out.println(InterfataAdmin.restaurante.toString());
                }
                else if ( alegere == 9){
                    System.out.println(InterfataAdmin.utilizatori.toString());
                }
                else if ( alegere == 10){
                    System.out.println("Introduceti ID-ul restaurantului");
                    System.out.println(actiuni.getRestaurantById(in.nextInt()).toString());
                }
            } catch (Exception e)
            {
                System.out.println(e.toString());
            }
            alegere = in.nextInt();
        }
    }
}
