package com.kubilaycicek;


import lombok.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Data
public class DatabaseManager {
    DatabaseSingleton databaseSingleton = null;

    private Statement statement = null;

    public DatabaseManager() throws SQLException {
        databaseSingleton = new DatabaseSingleton();
    }

    public List<City> getCities() throws SQLException {

        List<City> cities = new ArrayList<>();
        String sql = "SELECT * FROM city";
        statement = databaseSingleton.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            City city = new City();
            city.setId(rs.getInt("ID"));
            city.setName(rs.getString("Name"));
            city.setPopulation(rs.getInt("Population"));
            city.setCountryCode(rs.getString("CountryCode"));
            city.setDistrict(rs.getString("District"));
            cities.add(city);
        }
        return cities;
    }

    public void addCity(City city) throws SQLException {
        String sql = "INSERT INTO city (Name,CountryCode,District,Population) values (?,?,?,?) ";
        PreparedStatement preparedStatement = databaseSingleton.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, city.getName());
        preparedStatement.setString(2, city.getCountryCode());
        preparedStatement.setString(3, city.getDistrict());
        preparedStatement.setInt(4, city.getPopulation());
        preparedStatement.execute();
    }

    public void updateCity(City city) throws SQLException {
        String sql = "UPDATE city SET Name = ?, CountryCode = ?, District=?,Population=? WHERE ID = ?";
        PreparedStatement preparedStatement = databaseSingleton.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, city.getName());
        preparedStatement.setString(2, city.getCountryCode());
        preparedStatement.setString(3, city.getDistrict());
        preparedStatement.setInt(4, city.getPopulation());
        preparedStatement.setInt(5, city.getId());
        preparedStatement.execute();

    }

    public void removeCity(int cityId) throws SQLException {
        String sql = "DELETE FORM city where id = ?";
        PreparedStatement preparedStatement = databaseSingleton.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, cityId);
        int result = statement.executeUpdate(sql);
        System.out.println("Delete " + result);
    }
}
