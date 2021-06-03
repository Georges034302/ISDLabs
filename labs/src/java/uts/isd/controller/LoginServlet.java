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
import uts.isd.controller.Validator;
import uts.isd.model.*;
import uts.isd.model.dao.mongo.*;
import uts.isd.model.dao.sql.UserSQLDAO;

/**
 *
 * @author george
 */
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        Validator.clear(session);
        String email = request.getParameter("email");
        String password = request.getParameter("password"); 
        UserMongoDAO userDAO = (UserMongoDAO) session.getAttribute("userDAO"); 
        //UserSQLDAO userDAO = (UserSQLDAO) session.getAttribute("userDAO");
        User user = null;
        try {
            user = userDAO.login(email, password);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "User does not exist" : "welcome");
        }
        validator.clear(session);

        if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Password format incorrect");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            try {
                if (user != null) {
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("main.jsp").forward(request, response);
                } else {
                    session.setAttribute("existErr", "User does not exist in the Database!");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } catch (NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "Cannot open Mongo Connection" : "welcome");
            }
        }
    }
}
