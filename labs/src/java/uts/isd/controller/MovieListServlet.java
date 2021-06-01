/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import uts.isd.model.dao.testers.MoviesXML;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;
import uts.isd.model.*;
import uts.isd.model.dao.*;

/**
 *
 * @author George
 */
public class MovieListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        MovieMongoDAO manager = new MovieMongoDAO();
        manager.connect("movies");
        ArrayList<Movie> matches = manager.fetchMovies();
        Movies movies = new Movies();
        movies.setMovies(matches);
        try {
            MoviesXML.generateXML(movies);
            String xmltxt = MoviesXML.marshal(movies);
            session.setAttribute("xmltxt", xmltxt);
        } catch (JAXBException ex) {
            Logger.getLogger(MovieListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("moviesView_BAK.jsp");
    }
}
