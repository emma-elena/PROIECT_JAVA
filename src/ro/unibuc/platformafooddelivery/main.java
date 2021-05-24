package ro.unibuc.platformafooddelivery;
import ro.unibuc.platformafooddelivery.services.DaoComenzi;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Actiuni actiuni = new Actiuni();
        System.out.println("Pentru a iesi din meniu va rugam apasati -1");
        System.out.println("Pentru a adauga un utilizatori nou apasati 1");
        System.out.println("Pentru a adauga un sofer nou apasati 2");
        //la Actiune 3, daca introduc un nume de utilizator inexistent, imi va da lista cu toti utilizatorii si id-urile lor ca sa ii am in fata sa stiu ce aleg
        System.out.println("Pentru a adauga o comanda apasati 3");
        System.out.println("Pentru a adauga un restaurant apasati 4");
        System.out.println("Pentru a vedea o comanda apasati 5");
        System.out.println("Pentru a vedea datele unui utilizator apasati 6");
        System.out.println("Pentru a vedea care sunt toate comenzile apasati 7");
        System.out.println("Pentru a vedea care sunt toate restaurantele apasati 8");
        System.out.println("Pentru a vedea toti utilizatorii apasati 9");
        System.out.println("Pentru a vedea un detalii despre un restaurant apasati 10");
        System.out.println("Afiseaza utilizatori din fisier 11");
        System.out.println("Afiseaza utilizatori din db 12");
        System.out.println("Sterge utilizatori din db 13");
        System.out.println("Actualizeaza adresa utilizatorului in functie de nume in DB 14");
        System.out.println("Selecteaza comanada utilizatorului 15");
        System.out.println("Afiseaza id utilizatori 16 (cu map)");

        int alegere = in.nextInt();
        //Pentru a iesi din meniu apasati -1
        while (alegere > 0) {
            try {
                if (alegere == 1) {
                    actiuni.adaugaUtilizator(in);
                } else if (alegere == 2) {
                    actiuni.adaugaSofer(in);
                    actiuni.alegere2();
                } else if (alegere == 3) {
                    actiuni.adaugaComanda(in);
                    actiuni.alegere3();
                } else if (alegere == 4) {
                    actiuni.adaugaRestaurant(in);
                    actiuni.alegere4();
                } else if (alegere == 5) {
                    System.out.println("Introduceti ID-ul comenzii pentru care doriti detalii");
                    actiuni.incarcaComenzi(in.next());
                    actiuni.alegere5();
                } else if (alegere == 6) {
                    System.out.println("Introduceti ID-ul utilizatorului pentru care doriti detalii");
                    System.out.println(actiuni.getUtilizatorById(in.nextInt()).toString());
                    actiuni.alegere6();
                } else if (alegere == 7) {
                    System.out.println(InterfataAdmin.comenzi.toString());
                    actiuni.alegere7();
                } else if (alegere == 8) {
                    System.out.println(InterfataAdmin.restaurante.toString());
                    actiuni.alegere8();
                } else if (alegere == 9) {
                    System.out.println(InterfataAdmin.utilizatori.toString());
                    actiuni.alegere9();
                } else if (alegere == 10) {
                    System.out.println("Introduceti ID-ul restaurantului");
                    System.out.println(actiuni.getRestaurantById(in.nextInt()).toString());
                    actiuni.alegere10();
                }else if (alegere == 11) {
                    System.out.println("Utilizatori:");
                    actiuni.afiseazaUtilizatori();
                }else if (alegere == 12) {
                    System.out.println("Selecteaza utilizatori:");
                    actiuni.selecteazaUtilizator(in);
                }else if (alegere == 13) {
                    System.out.println("Sterge utilizatori cu numele:");
                    actiuni.stergeUtilizator(in.next());
                }else if (alegere == 14) {
                    System.out.println("Actualizeaza adresa utilizatorului cu numele:");
                    String nume = in.next();
                    System.out.println("Adresa:");
                    actiuni.actualizeazaAdresa(nume, in.next());
                }else if (alegere == 15) {
                    System.out.println("Afiseaza comanda utilizatorului:");
                    String nume = in.next();
                    actiuni.selecteazaComandaUtilizator(nume);
                }else if (alegere == 16) {

                    System.out.println("Afiseaza utilizatori:");
                    actiuni.afiseazaUtilizatoriDb();
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            alegere = in.nextInt();
        }
    }
}
