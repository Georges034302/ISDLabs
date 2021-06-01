/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

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
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        MovieMongoDAO manager = (MovieMongoDAO) session.getAttribute("manager");
        ArrayList<Movie> matches = null;
        try {
            matches = manager.fetchMovies();
            Movies movies = new Movies();
            MoviesXML.generateXML(movies);
        } catch (JAXBException ex) {
            Logger.getLogger(MovieListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        matches.stream().forEach((Movie movie) -> {
            System.out.print(movie.getID());
        });        
    }    
}
