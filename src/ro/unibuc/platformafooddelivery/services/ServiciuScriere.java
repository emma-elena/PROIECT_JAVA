package ro.unibuc.platformafooddelivery.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ServiciuScriere {

    private static ServiciuScriere serviciuScriere = null;

    private ServiciuScriere() {
    }

    public static ServiciuScriere getInstance() {
        if (serviciuScriere == null) {
            serviciuScriere = new ServiciuScriere();
        }
        return serviciuScriere;
    }

    public void scrieLinie(String linie, File fisier) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fisier, true))) {
            bw.append(linie);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
