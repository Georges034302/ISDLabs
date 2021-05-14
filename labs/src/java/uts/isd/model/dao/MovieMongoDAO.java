package uts.isd.model.dao;

import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import uts.isd.model.*;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import java.util.Random;
import org.bson.Document;

/**
 * @author George Connect to MongoDB Atlas and perform CRUD operations
 * https://docs.mongodb.com/drivers/java/ [Java MongoDB Connection]
 * https://mvnrepository.com/ [JAR Repository]
 *
 */
public class MovieMongoDAO extends MongoDB {

    private MongoCollection<Document> collection;

    public MovieMongoDAO() {
        super();
    }

    public MovieMongoDAO(String owner, String password, String role, String db) {
        super(owner, password, role, db);
    }

    public void connect(String name) {
        this.collection = super.database.getCollection(name);
    }

    public void create(String name, String genre, double rating, int year, double price, String url) {
        Random r = new Random();
        int low = 100000;
        int high = 999999;
        int id = r.nextInt(high - low) + low;
        Document entity = new Document()
                .append("_id", id)
                .append("name", name)
                .append("genre", genre)
                .append("rating", rating)
                .append("year", year)
                .append("price", price)
                .append("url", url);
        this.collection.insertOne(entity);
    }

    public void read(String name, String year) {
        Document doc = this.collection.find(and(eq("name", name),eq("year", Integer.parseInt(year)))).first();
        if (doc != null) {
            PrettyJson.printJSON(doc);
        } else {
            System.out.println("Unknown Movie!!!");
        }
    }

    public void update(String name, String year, double rating, double price) {
         Document doc = this.collection.find(and(eq("name", name),eq("year", Integer.parseInt(year)))).first();
        if (doc != null) {
            this.collection.updateOne(
                    eq("name", name),
                    combine(
                            set("rating", rating),
                            set("price", price)                            
                    ));
            System.out.println(name + " details have been updated.");
        } else {
            System.out.println("Unknown Movie!!!");
        }
    }

    public void delete(String name, String year) {
        Document doc = this.collection.find(and(eq("name", name),eq("year", Integer.parseInt(year)))).first();
        if (doc != null) {
            this.collection.deleteOne(and(eq("name", name),eq("year", Integer.parseInt(year))));
            System.out.println(name + " has been deleted.");
        } else {
            System.out.println("Unknown Movie!!!");
        }
    }

    //View MongoDB Collections associated with credentials
    public void viewDatabase() {
        System.out.println("MongoDB database information::");
        System.out.println("Database :: " + super.database.getName());
        System.out.println("Credentials :: " + super.credential);
        for (String name : super.database.listCollectionNames()) {
            System.out.println("Collections :: " + name);
        }
    }

    //View a collection data as Json format
    public void showCollection() {
        MongoCursor<Document> cursor = this.collection.find().iterator();
        while (cursor.hasNext()) {
            PrettyJson.printJSON(cursor.next());
        }
    }
    
    public ArrayList<Movie> fetchMovies(){
        ArrayList<Movie> temp = new ArrayList<>();
        
        return temp;
    }
}
