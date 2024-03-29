package uts.isd.model.dao.testers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import uts.isd.model.*;
import uts.isd.model.dao.*;


/**
 *
 * @author george
 */
public class UserDAOTester {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new UserDAOTester().menu();
    }
    
    private SQLDBConnecter connector;
    private Connection conn;
    private UserDAO manager;

    public UserDAOTester() throws ClassNotFoundException, SQLException {
        connector = new SQLDBConnecter();
        conn = connector.connection();
        manager = new UserDAO(conn);
    }

    private void testCreate() throws SQLException {
        System.out.println("Adding user to the database: ");
        manager.createUser(read("Email"), read("Name"), read("Password"), read("Phone"));
        System.out.println("User added successfully ");
    }
    
    private void testRead() throws SQLException{
        String email = read("Email");
        String pass = read("Password");
        User user = manager.login(email, pass);
        String exist = (user != null) ? "User "+user.getName()+" exists in the database" : "User does not exist!!!";
        System.out.println(exist);
    }

    private void testUpdate() throws SQLException{
        String email = read("Email");
        String pass = read("Password");
        User user = manager.login(email, pass);
        if(user != null){      
            System.out.println("Updating "+user.getName()+" account details");
            manager.update(read("Name"),  read("Password"), read("Phone"),user.getID());
            System.out.println("User details updated successfully ");
        }else{
            System.out.println("User does not exist");
        }
    }
    
    private void testDelete() throws SQLException{
        String email = read("Email");
        String pass = read("Password");
        User user = manager.login(email, pass);
        if(user != null){        
            manager.delete(email, pass, user.getID());
            System.out.println("User "+user.getName()+" account has been deleted");
        }else{
            System.out.println("User does not exist");
        }
    }
    
    private void testFetch() throws SQLException{
        System.out.printf("\n%-15s %-25s %-25s %-15s %-15s \n","ID", "NAME", "EMAIL","PASSWORD", "PHONE");
        ArrayList<User> users = manager.fetchUsers();
        for (User user : users) {
            System.out.printf("%-15s %-25s %-25s %-15s %-15s  \n",user.getID(),user.getName(),user.getEmail(),user.getPassword(),user.getPhone());
        }
        System.out.println();
    }
    
    private String read(String prompt) {
        System.out.print(prompt + ": ");
        return in.nextLine();
    }
    private void menu() throws SQLException{
        char c;
        help();
        while((c=read("Command [c/r/u/d/f/x]").charAt(0)) != 'x'){
            switch(c){
                case 'c': testCreate();break;
                case 'r': testRead(); break;
                case 'u': testUpdate(); break;
                case 'd': testDelete();break;
                case 'f': testFetch();break;
                default: help(); break;
            }
        }
    }
    private void help(){
        System.out.println("Database Operations: \n"
                + "c = Create User \n"
                + "r = Read User by ID-Password \n"
                + "u = Update User by ID \n"
                + "d = Delete User by ID\n"
                + "f = Fetch all Users\n");
    }
}