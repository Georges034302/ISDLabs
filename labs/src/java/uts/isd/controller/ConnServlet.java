/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.mongo.MovieMongoDAO;
import uts.isd.model.dao.mongo.UserMongoDAO;
import uts.isd.model.dao.sql.*;

public class ConnServlet extends HttpServlet {

    /*
    private SQLDBConnector db;
    private UserSQLDAO userDAO;
    private Connection conn;
     */
    private MovieMongoDAO manager;
    private UserMongoDAO userDAO;

    @Override //Create and instance of DBConnector for the deployment session
    public void init() {
        //db = new SQLDBConnector();

        userDAO = new UserMongoDAO();
        manager = new MovieMongoDAO();
        userDAO.connect("users");
        manager.connect("movies");
    }

    @Override //Add the DBManager instance to the session 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        try {
            //conn = db.connection();
            //userDAO = new UserSQLDAO(conn);
        } catch (NullPointerException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        //export the DB manager to the view-session (JSPs)        
        session.setAttribute("userDAO", userDAO);
        session.setAttribute("manager", manager);        
    }

    @Override //Destroy the servlet and release the resources of the application
    public void destroy() {
        //db.closeConnection();
    }
}
