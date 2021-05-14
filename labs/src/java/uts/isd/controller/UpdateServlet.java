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
import uts.isd.model.dao.*;

/**
 *
 * @author George
 */
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        User user = new User(name, email, password, phone, gender, dob);
        SQLUserDAO userDAO = (SQLUserDAO) session.getAttribute("userDAO");
        try {
            if (user != null) {
                session.setAttribute("user", user);
                userDAO.updateUser(id, name, email, name, phone, gender, dob);
                session.setAttribute("updated", "Update was successful");
                request.getRequestDispatcher("account.jsp").include(request, response);
            } else {
                session.setAttribute("updated", "Update was not successful!");
                request.getRequestDispatcher("account.jsp").include(request, response);
            }
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("account.jsp");        
    }
}
