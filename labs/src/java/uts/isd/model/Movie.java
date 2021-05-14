package uts.isd.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author George
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "movie")
public class Movie implements Serializable{
    @XmlElement(name = "ID")
    private String ID;   
    @XmlElement(name = "name")
    private String name; 
    @XmlElement(name = "genre")
    private String genre;
    @XmlElement(name = "rating")
    private double rating;
    @XmlElement(name = "year")
    private int year;
    @XmlElement(name = "price")
    private double price;
    @XmlElement(name = "url")
    private String url;

    public Movie() { }
    
    public Movie(String ID, String name, String genre,double rating, double price, String url) {
        this.ID = ID;
        this.name = name;
        this.genre = genre;
        this.rating = rating;
        this.price = price;
        this.url = url;
    }

    public boolean match(String ID){
        return this.ID.equals(ID);
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
       
    @Override
    public String toString(){
        return "Movie ID: "+ID+" Name: "+name+" Genre: "+genre+" rating: "+String.format("%0.f", rating)+" year: "+year+" price: "+String.format("%.3f", price)+" URL: "+url;
    }
}
