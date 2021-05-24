package ro.unibuc.platformafooddelivery.services;

import ro.unibuc.platformafooddelivery.Utilizator;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

//DaoUtilizator = un serviciu care comunica cu baza de date
//Dao = Data Access Object
public class DaoUtilizator {

    private static DaoUtilizator daoUtilizator = null;
//private final ca sa fie singletone
//Singletone = da de fiecare data aceeasi instanta a clasei ca sa nu creeze obiecte separate de fiecare data
    private final String insertUtilizator = "insert into utilizator (nume, data_nasterii, adresa) values (?, ?, ?)";
    private Connection connection;

    //Conexiunea cu DB
    private DaoUtilizator() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//e.printStackTrace() = metoda in Java pentru erori si exceptii. Imi arata exact numarul liniei si numele
//clasei unde a avut loc exceptia


    public static DaoUtilizator getInstance() {
        if (daoUtilizator == null)  //verifica daca e creat obiect, daca nu a fost deja creat
        {
            daoUtilizator = new DaoUtilizator();
        }
        return daoUtilizator;  //returneaza obiectul deja creat, obtin o singura instanta a clasei respective
    }

    public void insert(Utilizator utilizator) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertUtilizator);
            preparedStatement.setString(1, utilizator.getUserName());
            preparedStatement.setDate(2, new Date(utilizator.getDataNasterii().getTime())); //getTime da numarul de milisecunde de la data de 01.01.1970
            preparedStatement.setString(3, utilizator.getAdress());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Utilizator selecteazaUtilizatorCuNumele(String nume) {
        Utilizator utilizator = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ID, NUME, DATA_NASTERII, ADRESA FROM UTILIZATOR WHERE NUME = ?");
            preparedStatement.setString(1, nume);
            ResultSet resultSet = preparedStatement.executeQuery(); //executeQuery ca sa fac select si imi reurneaza un ResultSet
            //ResultSet contine mai multe randuri din DB
            while (resultSet.next())   //cu next se duce pe primul rand din baza mea de date
            {
                //in primul rand iau campurile corespondente campurilor de pe utilizatorul meu ca sa imi creez unul
                utilizator = new Utilizator(resultSet.getInt(1));  //primeste id-ul utilizatorului, 1 este numarul coloanei (ordinea din SELECT)
                utilizator.setUserName(resultSet.getString(2));
                utilizator.setDataNasterii(resultSet.getDate(3));
                utilizator.setAdress(resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilizator;   //imi returneaza un utilizator care se duce in Actiuni pentru a il afisa
    }

    public Utilizator getUtilizatorDupaID(int id) {
        Utilizator utilizator = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ID, NUME, DATA_NASTERII, ADRESA FROM UTILIZATOR WHERE ID = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery(); //executeQuery ca sa fac select si imi reurneaza un ResultSet
            //ResultSet contine mai multe randuri din DB
            while (resultSet.next())   //cu next se duce pe primul rand din baza mea de date
            {
                //in primul rand iau campurile corespondente campurilor de pe utilizatorul meu ca sa imi creez unul
                utilizator = new Utilizator(resultSet.getInt(1));  //primeste id-ul utilizatorului, 1 este numarul coloanei (ordinea din SELECT)
                utilizator.setUserName(resultSet.getString(2));
                utilizator.setDataNasterii(resultSet.getDate(3));
                utilizator.setAdress(resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilizator;   //imi returneaza un utilizator care se duce in Actiuni pentru a il afisa
    }

    public void deleteUtilizator(String nume) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM UTILIZATOR WHERE NUME = ?");
            preparedStatement.setString(1, nume);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizeazaAdresa(String nume, String adresa) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE UTILIZATOR SET ADRESA = ? WHERE NUME = ?");
            preparedStatement.setString(1, adresa);
            preparedStatement.setString(2, nume);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //map(aplicatii gen update, delete pe baza unei chei primare) = lista cu toti utilizatorii din baza de date cu id-urile lor, cheie si valoare
    //Actiunea 16
    public Map<Integer, String> selecteazaIdurileUtilizatorilor() {
        PreparedStatement preparedStatement = null;
        Map<Integer, String> idSiNume = new HashMap<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT ID, NUME FROM UTILIZATOR");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                idSiNume.put(resultSet.getInt(1), resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idSiNume;
    }
}

