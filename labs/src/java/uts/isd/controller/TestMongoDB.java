package uts.isd.controller;

/**
 *
 * @author George
 */
import java.sql.*;
import java.util.*;
import uts.isd.model.dao.*;

public class TestMongoDB {

    private static Scanner in = new Scanner(System.in);
    private MongoDBManager mongo;

    public static void main(String[] args) throws SQLException {
        TestMongoDB testDB = new TestMongoDB();        
        testDB.runQueries();
    }

    public TestMongoDB() {        
        connect();
    }

    //Connect to a db on Atlas and access a collection from this db
    private void connect() {
        String name = read(">> Access collection");
        String user = read("Username");
        String pass = read("Password");
        String role = read("Role");
        String db = read("DB");
        this.mongo = new MongoDBManager(user,pass,role,db);       
        this.mongo.connect(name);
        System.out.println(">> Connected to MongoDB-" + name + " collection.\n");
    }

    private char readChoice() {
        System.out.print("Operation CRUDS-V or * to exit: ");
        return in.nextLine().charAt(0);
    }

    private void runQueries() throws SQLException {
        char c;

        while ((c = readChoice()) != '*') {
            switch (c) {
                case 'C':
                    testCreate();
                    break;
                case 'R':
                    testRead();
                    break;
                case 'U':
                    testUpdate();
                    break;
                case 'D':
                    testDelete();
                    break;
                case 'S':
                    showAll();
                    break;
                case 'V':
                    view();
                    break;
                case 'E':
                    connect();
                    break;
                default:
                    System.out.println("Unknown Command");
                    break;
            }
        }
    }

    private String read(String action) {
        System.out.print(" "+action + ": ");
        return in.nextLine();
    }

    private void testCreate() {
        mongo.create(read("Name"), read("Email"), read("Password"), read("Phone"), read("Gender"), read("Date of Birth"));
    }

    private void testRead() {
        mongo.read(read("ID"), read("Password"));
    }

    private void testUpdate() {
        mongo.update(read("ID"), read("Password"), read("Name"), read("Email"), read("Phone"), read("Gender"), read("Date of Birth"));
    }
    private void testDelete() {
        mongo.delete(read("ID"), read("Password"));
    }

    private void view() {
        mongo.viewDatabase();
    }

    private void showAll() {
        mongo.showCollection();
    }
}

