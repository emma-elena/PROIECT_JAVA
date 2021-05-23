package ro.unibuc.platformafooddelivery.services;

import ro.unibuc.platformafooddelivery.Audit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


//serviciu responsabil doar de audit, inregistreaza actiuni
//Audit -> un fel de istoric
public class ServiciuAudit {

    private static ServiciuAudit serviciuAudit = null;

    private final DaoAudit daoAudit;

    private ServiciuAudit() {
        daoAudit = DaoAudit.getInstance();
    }

    public static ServiciuAudit getInstance() {
        if (serviciuAudit == null) {
            serviciuAudit = new ServiciuAudit();
        }
        return serviciuAudit;
    }


    //creeaza un audit
    public void inregistrareAudit(String actiune) {
        Audit audit = new Audit(actiune, new Date(System.currentTimeMillis()));
        inregistreazaInFisier(audit);  //inregistreaza in fisier
        daoAudit.insert(audit);        //inregistreaza in baza de date
    }

    private void inregistreazaInFisier(Audit audit) {
        try {
            File file = new File("time.csv");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter writer = new BufferedWriter(fr);
            writer.write(audit.toString());
            writer.newLine();
            writer.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
