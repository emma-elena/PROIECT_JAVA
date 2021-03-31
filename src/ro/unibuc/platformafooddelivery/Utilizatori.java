package ro.unibuc.platformafooddelivery;

import org.jetbrains.annotations.NotNull;

import java.util.Date;


public class Utilizatori {
    @NotNull //ca nu poti sa le lasi goale
    protected String userName;
    protected final int id;
    protected Date dataNasterii; //(yyyy-mm-zz)
    protected String adresa;
    private static int contor = 0;

    public Utilizatori(@NotNull String userName, Date dataNasterii, String adress) {
        this.userName = userName;
        this.dataNasterii = dataNasterii;
        this.adresa = adress;
        contor++;
        this.id = contor;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setDataNasterii(Date dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public void setAdress(String adress) {
        this.adresa = adresa;
    }

    public String getUserName() {
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
        return "Utilizatori{" +
                "userName='" + userName + '\'' +
                ", id=" + id +
                ", dataNasterii=" + dataNasterii +
                ", adress='" + adresa + '\'' +
                '}';
    }
}
