/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.*;
import uts.isd.model.dao.*;

/**
 *
 * @author George
 */
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("password");
        SQLUserDAO userDAO = (SQLUserDAO) session.getAttribute("userDAO");

        User user = null;
        try {
            user = userDAO.readUser(id, password);
        } catch (SQLException | NullPointerException ex ) {
            Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (user != null) {
            session.setAttribute("user", user);
            request.getRequestDispatcher("profile.jsp").include(request, response);
        } else {
            session.setAttribute("existErr", "User does not exist in the Database!");
            request.getRequestDispatcher("profile.jsp").include(request, response);
        }        
        request.getRequestDispatcher("profile.jsp").include(request, response);
    }    
}
