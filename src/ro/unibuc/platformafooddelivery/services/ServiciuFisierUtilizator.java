package ro.unibuc.platformafooddelivery.services;

import ro.unibuc.platformafooddelivery.Utilizator;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ServiciuFisierUtilizator {

    private static ServiciuFisierUtilizator serviciuFisierUtilizator = null;
    private String file = "src/ro/unibuc/platformafooddelivery/utiliz.csv";

    //serviciile generice scriere si citire
    private ServiciuScriere serviciuScriere;
    private ServiciuCitire serviciuCitire;

    private ServiciuFisierUtilizator() {
        serviciuCitire = ServiciuCitire.getInstance();
        serviciuScriere = ServiciuScriere.getInstance();
    }

    public static ServiciuFisierUtilizator getInstance() {
        if (serviciuFisierUtilizator == null) {
            serviciuFisierUtilizator = new ServiciuFisierUtilizator();
        }
        return serviciuFisierUtilizator;
    }

    public void scrie(Utilizator utilizator) {
        serviciuScriere.scrieLinie(utilizator.toCsv(), new File(file));
    }


    public List<Utilizator> citesteOrdonatDupaData() {
        List<Utilizator> utilizatori = new ArrayList<>();
        List<String> continutCsv = serviciuCitire.citesteContinutFisier(new File(file));  //adauga continutul intr-o lista de utilizatori
        for (String linieCsv : continutCsv) {
            Utilizator obiectUtilizator;
            obiectUtilizator = transformaCsv(linieCsv);
            utilizatori.add(obiectUtilizator);
        }
        //apeleaza sort, comparatorul ii zice metodei sort sa compare utilizatorii folosind data nasterii, sortare lista de obiecte
        utilizatori.sort(Comparator.comparing(utilizator -> utilizator.getDataNasterii()));
        return utilizatori;
    }


    private Utilizator transformaCsv(String linieCsv) {
        String[] split = linieCsv.split(",");  //pentru fiecare linie face split si extrage un array de campuri
        //apoi creeaza un nou utilizator
        try {
            return new Utilizator(split[0], new SimpleDateFormat("yyyy-mm-dd").parse(split[1]), split[2]); //parsarea datei
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}

