package backend;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class Database {
    public static final MongoClient CLIENT = MongoClients.create(
            "mongodb+srv://backend:hamzaIsAMediocreProgrammer@cluster0-97ewx.gcp.mongodb.net/test?retryWrites=true&w=majority");
    public static final MongoDatabase DATABASE = CLIENT.getDatabase("CourseSelection");
    public static final MongoCollection<Document> COLLECTION_COURSES = DATABASE.getCollection("Courses");
}