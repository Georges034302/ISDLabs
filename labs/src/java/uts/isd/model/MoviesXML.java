package uts.isd.model;

import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import uts.isd.model.dao.*;

/**
 *
 * @author George
 */
public class MoviesXML {

    public MoviesXML() {
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, JAXBException {
        MovieMongoDAO manager = new MovieMongoDAO();
        manager.connect("movies");
        ArrayList<Movie> matches = manager.fetchMovies();
        Movies movies = new Movies();
        movies.setMovies(matches);
        MoviesXML.generateXML(movies);
    }

    public static void generateXML(Movies movies) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Movies.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        jaxbMarshaller.marshal(movies, System.out);
    }

    public static <T> String marshal(T input) throws JAXBException {
        StringWriter writer = new StringWriter();
        JAXBContext jc = JAXBContext.newInstance(input.getClass());
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(input, writer);
        return writer.toString();
    }
}
