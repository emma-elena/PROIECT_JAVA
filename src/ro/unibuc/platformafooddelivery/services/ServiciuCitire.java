package ro.unibuc.platformafooddelivery.services;

import ro.unibuc.platformafooddelivery.Utilizator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServiciuCitire {

    private static ServiciuCitire serviciuCitire = null;

    private ServiciuCitire() {
    }

    public static ServiciuCitire getInstance() {
        if (serviciuCitire == null) {
            serviciuCitire = new ServiciuCitire();
        }
        return serviciuCitire;
    }

    public List<String> citesteContinutFisier(File fisier) {
        List<String> content = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fisier))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.add(line);
            }
        } catch (FileNotFoundException e) {
            //Some error logging
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}

