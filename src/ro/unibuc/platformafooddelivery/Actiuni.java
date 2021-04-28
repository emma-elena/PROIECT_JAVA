package ro.unibuc.platformafooddelivery;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Aici voi implementa ce am in InterfataAdmin
public class Actiuni  implements InterfataAdmin{

    @Override
    public Utilizator getUtilizatorById(int id){
        for(Utilizator utilizatorul: utilizator){
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
    public void adaugaComanda(Scanner in){
        System.out.println("Introduceti numele restaurantului");
        String restaurant = in.next();

        System.out.println("Introduceti numele de utilizator");
        String utilizatorul = in.next();

        System.out.println("Introduceti numele mancarii");
        String mancarea = in.next();

        System.out.println("Introduceti numele bauturii");
        String bautura = in.next();

        System.out.println("Introduceti data sub forma aaaa-ll-zz");
        Date data = parseDate(in);

        //aici o sa creezi noua comanda care o sa aiba particularitatile introduse mai sus
        Comanda comanda = new Comanda(restaurant, utilizatorul,mancarea, bautura, data);
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
    public void adaugaUtilizator(Scanner in){
        System.out.println("Introduceti numele de utilizator");
        String userName = in.next();

        System.out.println("Introduceti data de nastere");
        Date dataNasterii = parseDate(in);

        System.out.println("Introduceti adresa");
        String adresa = in.next();

        //Utilizator acum a devenit un tip de declarare cum este bool, int, string, char etc,
        // poti declara un obiect de tip Utilizator
        Utilizator utilizatorul = new Utilizator(userName, dataNasterii, adresa);
        utilizator.add(utilizatorul);
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
        writer.write("S-au vizualizat datele unui utilizator" + formatter.format(date));
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