package com.kubilaycicek;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        DatabaseManager database = new DatabaseManager();

        List<City> list = database.getCities();
        System.out.println(list.toString());

        /*
        City city = new City();
        city.setId(4082);
        city.setName("KubilayYYYYYYYYYY");
        city.setDistrict("ASDDDDDDD");
        city.setCountryCode("ABW");
        city.setPopulation(111);
        database.updateCity(city);
        */

        /*
        City city = new City();
        city.setId(4082);
        city.setName("KubilayYYYYYYYYYY");
        city.setDistrict("ASDDDDDDD");
        city.setCountryCode("ABW");
        city.setPopulation(111);
        database.updateCity(city);
        */


    }
}
