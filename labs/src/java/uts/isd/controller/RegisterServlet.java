package uts.isd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.controller.Validator;
import uts.isd.model.User;
import uts.isd.model.dao.mongo.*;

/**
 *
 * @author George
 */
public class RegisterServlet extends HttpServlet {  

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        Validator.clear(session);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
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
            session.setAttribute("emailErr", "Error: Email format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validateName(name)) {
            session.setAttribute("nameErr", "Error: Name format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Passowrd format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else {
            try {
                if (user != null) {
                    session.setAttribute("existErr", "Student already exists in the Database!");
                    request.getRequestDispatcher("register.jsp").include(request, response);
                } else {
                    userDAO.create(name, email, name, phone, gender, dob);
                    user = new User(name, email, password, phone, gender, dob);
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("main.jsp").include(request, response);
                }
            } catch (NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "Cannot open Mongo Connection" : "welcome");
            }
        }
    }
}
