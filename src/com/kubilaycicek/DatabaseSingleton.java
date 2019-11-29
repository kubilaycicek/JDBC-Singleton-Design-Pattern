package com.kubilaycicek;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

@Data
public class DatabaseSingleton {
    private String dbName = "world";
    private String dbUserName = "root";
    private String dbPassword = "admin";
    private String dbHost = "localhost";
    private int dbPort = 3306;
    private String dbTimeZoneConfig = "useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    private Connection connection;
    private static DatabaseSingleton databaseManagerInstance;

    DatabaseSingleton() throws SQLException {
        String url = "jdbc:mysql://" + this.getDbHost() + ":" + this.getDbPort() + "/" + this.getDbName() + "?" + this.getDbTimeZoneConfig();
        //Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            this.setConnection(DriverManager.getConnection(url, this.getDbUserName(), this.getDbPassword()));
            System.out.println("Connection is open");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static DatabaseSingleton getInstance() throws SQLException {
        if (databaseManagerInstance == null)
            databaseManagerInstance = new DatabaseSingleton();
        else if (databaseManagerInstance.getConnection().isClosed())
            databaseManagerInstance = new DatabaseSingleton();
        return databaseManagerInstance;
    }
}
