package ro.unibuc.platformafooddelivery;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Utilizator {
    @NotNull //ca nu poti sa le lasi goale
    protected String userName;
    protected final int id;
    protected Date dataNasterii; //(yyyy-mm-zz)
    protected String adresa;
    private static int contor = 0;

    public Utilizator(int id) {
        this.id = id;
    }

    public Utilizator(@NotNull String userName, Date dataNasterii, String adresa) {
        this.userName = userName;
        this.dataNasterii = dataNasterii;
        this.adresa = adresa;
        contor++;
        this.id = contor;
    }

    public void setUserName(@NotNull String userName) {
        this.userName = userName;
    }

    public void setDataNasterii(Date dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public void setAdress(String adresa) {
        this.adresa = adresa;
    }

    public @NotNull String getUserName() {
        return userName;
    }

    public int getId() {
        return id;
    }

    public Date getDataNasterii() {
        return dataNasterii;
    }

    public String getAdress() {
        return adresa;
    }

    @Override
    public String toString() {
        return "Utilizator{" +
                "userName='" + userName + '\'' +
                ", id=" + id +
                ", dataNasterii=" + new SimpleDateFormat("yyyy-MM-dd").format(dataNasterii) +
                ", adresa='" + adresa + '\'' +
                '}';
    }


    //metoda toCsv pentru a concatena campurile, imi creeaza o linia din cod
    public String toCsv()
    {
        return userName + "," + new SimpleDateFormat("yyyy-MM-dd").format(dataNasterii) + "," + adresa;
    }
}

