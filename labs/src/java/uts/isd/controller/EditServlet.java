package uts.isd.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.User;
import uts.isd.model.dao.mongo.*;
import uts.isd.model.dao.sql.UserSQLDAO;

/**
 *
 * @author George
 */
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserMongoDAO userDAO = (UserMongoDAO) session.getAttribute("userDAO");
        //UserSQLDAO userDAO = (UserSQLDAO) session.getAttribute("userDAO");
        User user = null;
        try {
            user = userDAO.login(email, password);
            if (user != null) {
                session.setAttribute("user", user);
                request.getRequestDispatcher("account.jsp").include(request, response);
            } else {
                session.setAttribute("existErr", "User does not exist in the Database!");
                request.getRequestDispatcher("account.jsp").include(request, response);
            }
        } catch (NullPointerException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("account.jsp").include(request, response);
    }   
}
