package uts.isd.model.testers;

/**
 *
 * @author George
 */
import java.sql.*;
import java.util.*;
import uts.isd.model.dao.mongo.*;

public class TestMovieMongoDAO {

    private static final Scanner in = new Scanner(System.in);
    private MovieMongoDAO mongo;

    public static void main(String[] args) throws SQLException {
        TestMovieMongoDAO testDB = new TestMovieMongoDAO();        
        testDB.runQueries();
    }

    public TestMovieMongoDAO() {        
        connect();
    }

    //Connect to a db on Atlas and access a collection from this db
    private void connect() {
        System.out.println(">> Connecting to MongoDB-Atlas");
        /*
            String user = read("Username");
            String pass = read("Password");
            String role = read("Role");
            String db = read("DB");
        */
        String collection = read("Collection");
        this.mongo = new MovieMongoDAO();       
        this.mongo.connect(collection);
        System.out.println(">> Connected to MongoDB-" + collection + " collection.\n");
    }

    private char readChoice() {
        System.out.print("Operation CRUDS-V or * to exit: ");
        return in.nextLine().charAt(0);
    }

    private void runQueries() throws SQLException {
        char c;

        while ((c = readChoice()) != '*') {
            switch (c) {
                case 'C': testCreate();break;
                case 'R': testRead(); break;
                case 'U': testUpdate(); break;
                case 'D': testDelete(); break;
                case 'S': showAll(); break;
                case 'V': view(); break;
                default:  System.out.println("Unknown Command"); break;
            }
        }
    }

    private String read(String action) {
        System.out.print(" "+action + ": ");
        return in.nextLine();
    }

    private void testCreate() {
        mongo.create(read("Name"), read("Genre"), 
                Double.parseDouble(read("Rating")), 
                Integer.parseInt(read("year")), 
                Double.parseDouble(read("Price")), 
                read("URL"));
    }

    private void testRead() {
        mongo.read(read("ID"), read("Password"));
    }

    private void testUpdate() {
        mongo.update(read("Name"), read("year"),
                Double.parseDouble(read("Rating")), 
                Double.parseDouble(read("Price")));
    }
    private void testDelete() {
        mongo.delete(read("Name"), read("Year"));
    }

    private void view() {
        mongo.viewDatabase();
    }

    private void showAll() {
        mongo.showCollection();
    }
}

