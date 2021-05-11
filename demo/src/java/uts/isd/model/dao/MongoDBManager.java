package uts.isd.model.dao;

import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import uts.isd.model.*;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.Iterator;
import java.util.List;
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

    public void create(String email, String name, String password, String phone, String gender, String dob) {
        
    }

    public void update(String email, String password) {
       
    }

    public void read(String email, String password) {
        
    }

    public void delete(String email, String password) {
       
    }

    //View MongoDB Collections associated with credentials
    public void viewDatabase() {
        
    }

    //View a collection data as Json format
    public void showCollection() {
        
    }
}
