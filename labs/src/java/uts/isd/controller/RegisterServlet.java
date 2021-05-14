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
import uts.isd.model.User;
import uts.isd.model.dao.UserManager;

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
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        UserManager manager = (UserManager) session.getAttribute("manager");        
        validator.clear(session);
        
        if(!validator.validateEmail(email)){
            session.setAttribute("emailErr", "Error: Email format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }else if(!validator.validateName(name)){
            session.setAttribute("nameErr", "Error: Name format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Passowrd format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else {
            try {                
                if(manager.verifyUser(email,password)){
                    session.setAttribute("existErr", "Student already exists in the Database!");
                    request.getRequestDispatcher("register.jsp").include(request, response);
                }else{
                    manager.createUser(name, email, name, phone, gender, dob);
                    User user = new User(name,email,password,phone,gender,dob);
                    session.setAttribute("user", user);            
                    request.getRequestDispatcher("main.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }          
    }
}
