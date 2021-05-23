package ro.unibuc.platformafooddelivery.services;

import ro.unibuc.platformafooddelivery.Audit;
import ro.unibuc.platformafooddelivery.Comanda;

import java.sql.*;

public class DaoAudit {

    private static DaoAudit daoAudit = null;

    private Connection connection;

    private DaoAudit() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DaoAudit getInstance() {
        if (daoAudit == null) {
            daoAudit = new DaoAudit();
        }
        return daoAudit;
    }

    public void insert(Audit audit) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO AUDIT (ACTIUNE, TIMESTAMP_AUDIT ) VALUES (?,?)");
            preparedStatement.setString(1, audit.getActiune());
            preparedStatement.setTimestamp(2, new Timestamp(audit.getDataActiunii().getTime()));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}

