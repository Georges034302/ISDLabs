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
public class UserMongoDAO extends MongoDB {

    private MongoCollection<Document> collection;

    public UserMongoDAO() {
        super();
    }

    public UserMongoDAO(String owner, String password, String role, String db) {
        super(owner, password, role, db);
    }

    public void connect(String name) {
        this.collection = super.database.getCollection(name);
    }

    public void create(String name, String email, String password, String phone, String gender, String dob) {
        Random r = new Random();
        int low = 100000;
        int high = 999999;
        int id = r.nextInt(high - low) + low;
        Document entity = new Document()
                .append("_id", id)
                .append("name", name)
                .append("email", email)
                .append("password", password)
                .append("phone", phone)
                .append("gender", gender)
                .append("DOB", dob);
        this.collection.insertOne(entity);
    }

    public void read(String id, String password) {
        Document doc = this.collection.find(and(eq("_id", Integer.parseInt(id)), eq("password", password))).first();
        if (doc != null) {
            PrettyJson.printJSON(doc);
        } else {
            System.out.println("Unknown User!!!");
        }
    }

    public void update(String id, String password, String name, String email, String phone, String gender, String dob) {
        Document doc = this.collection.find(and(eq("_id", Integer.parseInt(id)), eq("password", password))).first();
        if (doc != null) {
            this.collection.updateOne(
                    eq("_id", Integer.parseInt(id)),
                    combine(
                            set("name", name),
                            set("email", email),
                            set("password", password),
                            set("phone", phone),
                            set("gender", gender),
                            set("DOB", dob)
                    ));
            System.out.println(name + " details have been updated.");
        } else {
            System.out.println("Unknown User!!!");
        }
    }

    public void delete(String id, String password) {
        Document doc = this.collection.find(and(eq("_id", Integer.parseInt(id)), eq("password", password))).first();
        if (doc != null) {
            this.collection.deleteOne(and(eq("_id", Integer.parseInt(id)), eq("password", password)));
            System.out.println(id + " account has been deleted.");
        } else {
            System.out.println("Unknown User!!!");
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
}
