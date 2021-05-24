package ro.unibuc.platformafooddelivery.services;


import ro.unibuc.platformafooddelivery.Comanda;

import java.sql.*;

public class DaoComenzi {

    private static DaoComenzi daoComenzi = null;

    private Connection connection;

    private DaoComenzi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DaoComenzi getInstance() {
        if (daoComenzi == null) {
            daoComenzi = new DaoComenzi();
        }
        return daoComenzi;
    }


    public Comanda selecteazaComandaIdUtilizator(int idUtilizator) {
        Comanda comanda = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ID, RESTAURANT, MANCARE, BAUTURA, DATA FROM COMENZI WHERE ID_UTILIZATOR = ?");
            preparedStatement.setInt(1, idUtilizator);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                comanda = new Comanda(resultSet.getInt(1));
                comanda.setRestaurant(resultSet.getString(2));
                comanda.setMancarea(resultSet.getString(3));
                comanda.setBautura(resultSet.getString(4));
                comanda.setData(resultSet.getDate(5));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comanda;
    }

    public Comanda getComenzi(String idComanda) {
        Comanda comanda = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ID, RESTAURANT, MANCARE, BAUTURA, DATA FROM COMENZI WHERE ID = ?");
            preparedStatement.setString(1, idComanda);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                comanda = new Comanda(resultSet.getInt(1));
                comanda.setRestaurant(resultSet.getString(2));
                comanda.setMancarea(resultSet.getString(3));
                comanda.setBautura(resultSet.getString(4));
                comanda.setData(resultSet.getDate(5));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comanda;
    }


    public void insert(Comanda comanda) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO COMENZI (RESTAURANT, MANCARE, BAUTURA, DATA, ID_UTILIZATOR) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, comanda.getRestaurant());
            preparedStatement.setString(2, comanda.getMancarea());
            preparedStatement.setString(3, comanda.getBautura());
            preparedStatement.setDate(4, new Date(comanda.getData().getTime()));
            preparedStatement.setInt(5, comanda.getIdUtilizator());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}