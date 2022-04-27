/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uts.isd.model.User;

/**
 *
 * @author george
 */
public class UserDAO {

    private Statement st;
    private PreparedStatement readSt;
    private PreparedStatement updateSt;
    private PreparedStatement deleteSt;
    private String readQuery =  "SELECT * FROM USERS WHERE EMAIL=? AND PASSWORD=?";
    private String updateQuery = "UPDATE USERS SET \"NAME\"=? ,PASSWORD=? ,PHONE=? WHERE ID=?";
    private String deleteQuery = "DELETE FROM USERS WHERE ID= ?";
    
    public UserDAO(Connection connection) throws SQLException {
        connection.setAutoCommit(true);
        st = connection.createStatement();
        readSt =  connection.prepareStatement(readQuery);
        updateSt = connection.prepareStatement(updateQuery);
        deleteSt = connection.prepareStatement(deleteQuery);
    }

    //Create Operation: create a user
    public void createUser(String email, String name, String password, String phone) throws SQLException {
        String columns = "INSERT INTO USERS(EMAIL,\"NAME\",PASSWORD,PHONE)";
        String values = "VALUES('" + email + "','" + name + "','" + password + "','" + phone + "')";
        st.executeUpdate(columns + values);
    }

    //Read Operation: user login
    public User login(String email, String password) throws SQLException {
        readSt.setString(1, email);
        readSt.setString(2, password);
        ResultSet rs = readSt.executeQuery();
        
        while (rs.next()) {
            String useremail = rs.getString(2);
            String userpass = rs.getString(4);
            if (email.equals(useremail) && password.equals(userpass)) {
                int ID = Integer.parseInt(rs.getString(1));
                String name = rs.getString(3);
                String phone = rs.getString(5);
                return new User(ID, email, name, password, phone);
            }
        }
        return null;
    }

    //Update Operation: update user
    public void update(String name, String password, String phone, int ID) throws SQLException {
        updateSt.setString(1, name);
        updateSt.setString(2, password);
        updateSt.setString(3, phone);
        updateSt.setString(4, Integer.toString(ID));
        int row = updateSt.executeUpdate();
        System.out.println("row "+row+" updated successfuly");
    }

    //Delete Operation: delete a user by email & password
    public void delete(String email, String password, int ID) throws SQLException {
        deleteSt.setString(1, Integer.toString(ID));
        int row = deleteSt.executeUpdate();
        System.out.println("row "+row+" deleted successfuly");
    }

    //Fetch All: List all users
    public ArrayList<User> fetchUsers() throws SQLException {
        String fetch = "SELECT * FROM USERS";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<User> users = new ArrayList();

        while (rs.next()) {
            int ID = Integer.parseInt(rs.getString(1));
            String email = rs.getString(2);
            String pass = rs.getString(4);
            String name = rs.getString(3);
            String phone = rs.getString(5);
            users.add(new User(ID, email, name, pass, phone));
        }
        return users;
    }
}
