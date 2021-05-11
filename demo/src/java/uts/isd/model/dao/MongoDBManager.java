package uts.isd.model.dao;

import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import uts.isd.model.*;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 * @author George Connect to MongoDB Atlas and perform CRUD operations
 * https://docs.mongodb.com/drivers/java/ [Java MongoDB Connection]
 * https://mvnrepository.com/ [JAR Repository]
 *
 */
public class MongoDBManager extends MongoDB {

    private MongoCollection<Document> collection;

    public MongoDBManager(String owner, String password, String role, String db) {
        super(owner, password, role, db);
    }

    public void connect(String name) {
        this.collection = super.database.getCollection(name);
    }

    public void create(String name, String email, String password, String phone, String gender, String dob) {
        
    }

    public void read(String id, String password) {
        
    }

    public void update(String id, String password, String name, String email, String phone, String gender, String dob) {
        
    }

    public void delete(String id, String password) {
        
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
}
