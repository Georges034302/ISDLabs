/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author george
 */
public class SQLDBConnecter extends SQLDB{
    public SQLDBConnecter() throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        super.connection = DriverManager.getConnection("jdbc:derby://localhost:1527/testdb;create=true");
    }
    
    public Connection connection(){
        return this.connection;
    }
    
    public void closeConnection() throws SQLException{
        this.connection.close();
    }
}
