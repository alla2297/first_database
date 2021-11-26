package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// opgave 3
public class DbSql {
    private Connection connection;
    private Statement stmt;
    DbSql(){
        connection = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:C://sqlite/studadm.db";//Indsæt dit eget databasenavn
            connection = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void opretStuderende(Connection connection){
        try {
            String sql = "CREATE TABLE IF NOT EXISTS studerende (\n"
                    + "	stdnr integer PRIMARY KEY,\n"
                    + "	fnavn TEXT NOT NULL,\n"
                    + "	enavn TEXT NOT NULL,\n"
                    + "	adresse TEXT NOT NULL,\n"
                    + "	postnr TEXT NOT NULL,\n"
                    + "	mobil TEXT NOT NULL,\n"
                    + "	klasse TEXT NOT NULL\n"
                    + ");";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public static void opretFag(Connection connection){
        try {
            String sql = "CREATE TABLE IF NOT EXISTS fag (\n"
                    + "	fagnr integer PRIMARY KEY,\n"
                    + "	fagnavn TEXT NOT NULL\n"
                    + ");";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public static void opretStudFag(Connection connection){
        try {
            String sql = "CREATE TABLE IF NOT EXISTS studfag (\n"
                    + "	stdnr integer, fagnr integer,\n"
                    + "FOREIGN KEY (stdnr) references studfag (stdnr),\n"
                    + "FOREIGN KEY (fagnr) references studfag (fagnr)\n"
                    + ");";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void indsaetstud(studerende s) {
        //Metoden indsætter s i tabellen studerende i din database
       try {
           String sql = "INSERT INTO studerende (id,fornavn,efternavn) VALUES(" +
                   String.valueOf(s.getStdnr()) + "','" + s.getFnavn() + "','" + s.getEnavn() + "'')";
           Statement stmt=connection.createStatement();
           stmt.execute(sql);
           System.out.println("Connection to SQLite has been established.");
       } catch (Exception e) {
           e.printStackTrace();
       }


    }



}
