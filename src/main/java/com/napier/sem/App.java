package com.napier.sem;

import java.sql.*;

public class App
{
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Get city
        City city = a.getCity(1);
        // Display results
        a.displayCity(city);

        // Get country
        Country country = a.getCountry("ABW");
        // Display results
        a.displayCountry(country);

        // Get Language
        CountryLanguage language = a.getLanguage("ABW");
        //Show Language
        a.displayCountryLanguage(language);

        // Disconnect from database
        a.disconnect();
    }
    /** get City Info from DB**/
    public City getCity(int ID)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, Name, CountryCode, District, Population "
                            + "FROM city ";
            // + "WHERE emp_no = " + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                City city = new City();
                city.iD = rset.getInt("id");
                city.name = rset.getString("name");
                city.countryCode = rset.getString("countrycode");
                city.district = rset.getString("district");
                city.population = rset.getInt("population");
                return city;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }
    /** Display Country Info **/
    public void displayCity(City city)
    {
        if (city != null)
        {
            System.out.println(
                    city.iD + " "
                            + city.name + " "
                            + city.countryCode + "\n"
                            + city.district + "\n"
                            + city.population + "\n"
                            + city.country + "\n");

        }
    }
    /** get Country Info from DB **/
    public Country getCountry(String code)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2  "
                            + "FROM country ";
            // + "WHERE emp_no = " + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                Country country = new Country();
                country.code = rset.getString("code");
                country.name = rset.getString("name");
                country.continent = rset.getString("continent");
                country.region = rset.getString("region");
                country.surfaceArea = rset.getDouble("surfacearea");
                country.population = rset.getInt("population");
                country.lifeExpectancy = rset.getDouble("lifeExpectancy");
                country.gnp = rset.getDouble("gnp");
                country.gnpOld = rset.getDouble("gnpOld");
                country.localName = rset.getString("localName");
                country.governmentForm = rset.getString("governmentForm");
                country.headOfState = rset.getString("headOfState");
                country.capital = rset.getInt("capital");
                country.code2 = rset.getString("code2");
                return country;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Country details");
            return null;
        }
    }
    /** Show Country Information **/
    public void displayCountry(Country country)
    {
        if (country != null)
        {
            System.out.println(
                    country.code + " "
                            + country.name + " "
                            + country.continent + "\n"
                            + country.region + "\n"
                            + country.surfaceArea +"\n"
                            + country.population +"\n"
                            + country.lifeExpectancy +"\n"
                            + country.gnp +"\n"
                            + country.gnpOld + "\n"
                            + country.localName +"\n"
                            + country.governmentForm +"\n"
                            + country.headOfState +"\n"
                            + country.capital +"\n"
                            + country.code2);

        }
    }

    public CountryLanguage getLanguage(String Code)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT CountryCode, Language, IsOfficial, Percentage "
                            + "FROM countrylanguage "
                            + "WHERE CountryCode = " + "CountryCode";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned
            if (rset.next())
            {
                CountryLanguage countryLanguage2 = new CountryLanguage();
                countryLanguage2.countryCode = rset.getString("CountryCode");
                countryLanguage2.language = rset.getString("Language");
                countryLanguage2.isOfficial = rset.getString("IsOfficial");
                countryLanguage2.percentage = rset.getInt("Percentage");
                return countryLanguage2;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get language details");
            return null;
        }
    }
    public void displayCountryLanguage(CountryLanguage countryLanguage2)
    {
        if (countryLanguage2 != null)
        {
            System.out.println(
                    countryLanguage2.countryCode + "\n"
                            + countryLanguage2.language + "\n"
                            + countryLanguage2.isOfficial + "\n"
                            + countryLanguage2.percentage + "\n");
        }
    }


    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?allowPublicKeyRetrieval=true&useSSL=false","root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }
}