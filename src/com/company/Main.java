package com.company;

import org.sqlite.core.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Connection connection = null;
        DbSql db =new DbSql();


        studerende s = new studerende();
        System.out.println("Indtast stdnr, fnavn, enavn, adresse, postnr, mobil og klasse");
        int stdnr;
        String fnavn, enavn,adresse,postnr,mobil,klasse;
        Scanner scan = new Scanner(System.in);
        s.setStdnr(scan.nextInt());
        s.setFnavn(scan.next());
        s.setEnavn(scan.next());
        /*
        s.setAdresse(scan.next());
        s.setPostnr(scan.next());
        s.setMobil(scan.next());
        s.setKlasse(scan.next());
        */


        DbSql.opretStuderende(connection);
        db.indsaetstud(s);
         //studerende s = new studerende(stdnr, fnavn, enavn,adresse,postnr,mobil,klasse);
        //DbSql.indsaetstud(s);

    }

}
