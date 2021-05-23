package ro.unibuc.platformafooddelivery;

import ro.unibuc.platformafooddelivery.services.DaoComenzi;
import ro.unibuc.platformafooddelivery.services.DaoUtilizator;
import ro.unibuc.platformafooddelivery.services.ServiciuAudit;
import ro.unibuc.platformafooddelivery.services.ServiciuFisierUtilizator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

//Aici voi implementa ce am in InterfataAdmin
public class Actiuni  implements InterfataAdmin{

    private final ServiciuFisierUtilizator serviciuFisierUtilizator;
    private final DaoUtilizator daoUtilizator;
    private final DaoComenzi daoComenzi;
    private final ServiciuAudit serviciuAudit;

    public Actiuni() {
        this.serviciuFisierUtilizator = ServiciuFisierUtilizator.getInstance();
        this.daoUtilizator = DaoUtilizator.getInstance();
        this.daoComenzi = DaoComenzi.getInstance();
        this.serviciuAudit = ServiciuAudit.getInstance();
    }

    @Override
    public Utilizator getUtilizatorById(int id){
        for(Utilizator utilizatorul: utilizatori){
            if(utilizatorul.getId() == id)
                return utilizatorul;
        }
        return null;
    }

    @Override
    public Comanda getComandaById(int id){
        for(Comanda comanda: comenzi)
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
    public void adaugaComanda(Scanner in)
    {
        System.out.println("Introduceti numele restaurantului");
        String restaurant = in.next();

        System.out.println("Introduceti numele de utilizatori");  //1) ia un nume de utilizator
        String utilizatorul = in.next();
        Utilizator utilizator = daoUtilizator.selecteazaUtilizatorCuNumele(utilizatorul); //2) selecteaza din baza de date utilizatorul cu numele introdus

        //cauta pana gaseste un utilizator sa corespunda cu ce caut
        while (utilizator == null)
        {
            System.out.println("Nume utilizator inexistent. Nume utilizatori existenti:");
            afiseazaUtilizatoriDb();
            utilizatorul = in.next();
            utilizator = daoUtilizator.selecteazaUtilizatorCuNumele(utilizatorul);
        }
        //daca nu exista imi va afisa lista cu id si nume de unde sa aleg
        System.out.println("Introduceti numele mancarii");
        String mancarea = in.next();

        System.out.println("Introduceti numele bauturii");
        String bautura = in.next();

        System.out.println("Introduceti data sub forma aaaa-ll-zz");
        Date data = parseDate(in);

        //aici o sa creezi noua comanda care o sa aiba particularitatile introduse mai sus
        Comanda comanda = new Comanda(restaurant, utilizatorul,mancarea, bautura, data);
        serviciuAudit.inregistrareAudit("S-a adaugate comanda: " + comanda.toString());
        comanda.setIdUtilizator(utilizator.getId());  //3) si ii preia id-ul si il pune in comanda
        comenzi.add(comanda); //aici o sa adaugi comanda in vectorul de comenzi
        daoComenzi.insert(comanda);
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
    public void adaugaUtilizator(Scanner in){
        System.out.println("Introduceti numele de utilizatori");
        String userName = in.next();

        System.out.println("Introduceti data de nastere");
        Date dataNasterii = parseDate(in);

        System.out.println("Introduceti adresa");
        String adresa = in.next();


        //Utilizator acum a devenit un tip de declarare cum este bool, int, string, char etc,
        // poti declara un obiect de tip Utilizator
        //Serviciul o sa scrie in audit de fiecare data
        Utilizator utilizatorul = new Utilizator(userName, dataNasterii, adresa);
        serviciuAudit.inregistrareAudit("S-a adaugate utilizatorul: " + utilizatorul.getUserName());
        utilizatori.add(utilizatorul);
        serviciuFisierUtilizator.scrie(utilizatorul);
        daoUtilizator.insert(utilizatorul);
    }


    @Override
    public void adaugaSofer(Scanner in){
        System.out.println("Introduceti numele soferului");
        String userName = in.next();

        System.out.println("Introduceti data nasterii");
        Date dataNasterii = parseDate(in);

        System.out.println("Introduceti adresa");
        String adresa = in.next();

        Sofer soferul = new Sofer(userName, dataNasterii, adresa);
        sofer.add(soferul);
    }

    public void alegere1() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("time.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("S-a adaugat un nou utilizator" + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void alegere2() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("time.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("S-a adaugat un nou sofer" + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void alegere3() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("time.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("S-a adaugat o comanda noua" + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void alegere4() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("time.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("S-a adaugat un nou restaurant" + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void alegere5() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("time.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("S-a vizualizat o comanda" + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void alegere6() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("time.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("S-au vizualizat datele unui utilizatori" + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void alegere7() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("time.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("S-au vizualizat toate comenzile" + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void alegere8() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("time.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("S-au vizualizat restaurante" + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void alegere9() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("time.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("S-au vizualizat utilizatori" + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void alegere10() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File("time.csv");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("S-au vizualizat detalii despre un restaurant" + formatter.format(date));
        writer.newLine();
        writer.close();
        fr.close();
    }

    public void selecteazaUtilizator(Scanner in) {
        System.out.println("Introduceti numele de utilizatori");
        String nume = in.next();
        System.out.println(daoUtilizator.selecteazaUtilizatorCuNumele(nume).toString());
    }

    public void afiseazaUtilizatori() {
        serviciuFisierUtilizator.citesteOrdonatDupaData().forEach(utilizator -> System.out.println(utilizator.toString()));
    }

    public void stergeUtilizator(String nume) {
        daoUtilizator.deleteUtilizator(nume);
    }

    public void actualizeazaAdresa(String nume, String adresa) {
        daoUtilizator.actualizeazaAdresa(nume, adresa);
    }

    public void selecteazaComandaUtilizator(String nume)  //trebuie sa selectam din DB utilizatorul dupa nume
    {
        Utilizator utilizator = daoUtilizator.selecteazaUtilizatorCuNumele(nume);   //returneza un obiect de tip utilizator
        if (utilizator != null)   //verifica daca e nul sau nu
        {
            Comanda comanda = daoComenzi.selecteazaComandaIdUtilizator(utilizator.getId());  // am extras id si in functie de asta am extras comanda
            System.out.println(comanda.toString());
        } else {
            System.out.println("Eroare! Utilizatorul selectat nu exista");
        }

    }

    //cu Map
    public void afiseazaUtilizatoriDb() {
        System.out.println("ID , NUME");
        for (Map.Entry<Integer, String> integerStringEntry : daoUtilizator.selecteazaIdurileUtilizatorilor().entrySet()) {
            System.out.println(integerStringEntry.getKey() + " , " + integerStringEntry.getValue());
        }
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