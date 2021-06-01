package uts.isd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.dao.*;

public class ConnServlet extends HttpServlet {

    //private SQLDBConnector db;
    //private SQLUserDAO userDAO;
    //private Connection conn;
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

    @Override //Add the DBConnector, DBManager, Connection instances to the session
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        //conn = db.connection();
        //userDAO = new SQLUserDAO(conn);
        //export the DB userDAO to the view-session (JSPs)
        session.setAttribute("userDAO", userDAO);
        session.setAttribute("manager", manager);
    }

    @Override //Destroy the servlet and release the resources of the application (terminate also the db connection)
    public void destroy() {
        //db.closeConnection();
    }
}
