/*
 * MongoDB super class setup the Mongo Atlas connection.
 */
package uts.isd.model.dao.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author George
 */
public class MongoDB {
    private MongoClientURI mongoURI;
    private MongoClient mongoClient;    
    protected MongoCredential credential;
    private CodecRegistry pojoCodecRegistry;
    
    private String authorization;
    private final ArrayList<String> clusters = new ArrayList<>();
    protected MongoDatabase database; //MongoDB super-class initializes and shares the MongoDatabase
    
    protected MongoDB(){
        loadClusters();        
        loadDBConfig("isduser", "superuser", "admin", "mFlix");
    }
    
    protected MongoDB(String user, String password, String role, String db) {        
        loadClusters();        
        loadDBConfig(user, password, role, db);        
    }    
    
    private void loadDBConfig(String user, String password, String role, String db){
        this.mongoURI = mongoClientURI(user, password, role, db);
        this.mongoClient = new MongoClient(this.mongoURI);
        this.database = this.mongoClient.getDatabase(db);
        this.credential = MongoCredential.createCredential(user, db, password.toCharArray());
        this.pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));       
        this.database = database.withCodecRegistry(pojoCodecRegistry);
    }
    
    private void loadClusters(){
        clusters.add("cluster0-shard-00-00-7c0ng.mongodb.net:27017");
        clusters.add("cluster0-shard-00-01-7c0ng.mongodb.net:27017");
        clusters.add("cluster0-shard-00-02-7c0ng.mongodb.net:27017");
    }
    
    private MongoClientURI mongoClientURI(String user, String password, String role, String db){
        this.authorization = "ssl=true&authSource=" + role + "&retryWrites=true";
        MongoClientURI uri = new MongoClientURI(
                ""
                + "mongodb://" + user + ":" + password + "@"
                + clusters.get(0)+","
                + clusters.get(1)+","
                + clusters.get(2)+"/" + db + "?"
                + this.authorization
                + ""
        );
        return uri;
    }
}
