package backend.TestingTools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

public class PortToDatabase {
    public static void main(String[] args) {
        //Connect to database
        MongoClient mongoClient = MongoClients.create(
                "mongodb+srv://backend:hamzaIsAMediocreProgrammer@cluster0-97ewx.gcp.mongodb.net/test?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("CourseSelection");
        MongoCollection<Document> collection = database.getCollection("Courses");
        ArrayList<Document> docs = new ArrayList<Document>();
        File dir = new File("./backend/courses");
        String[] paths = dir.list();
        //For Every file in courses converts into a Doc and inserts it
        for (String path : paths) {
            String jsonString = "";
            Scanner scan;
            try {
                scan = new Scanner(new File("./backend/courses/"+path));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                scan = null;
            }
            while (scan.hasNextLine()){
                jsonString += scan.nextLine()+"\n";
            }
            JSONObject obj = new JSONObject(jsonString);
            JSONArray prereq;
            try {
                prereq = obj.getJSONArray("prerequisites");
            } catch (Exception e) {
                JSONArray tags = obj.getJSONArray("tags");
                Document doc = new Document("name", obj.getString("name"))
                .append("department", obj.getString("department"))
                .append("hours", obj.getInt("hours"))
                .append("isBlended", obj.getBoolean("isBlended"))
                .append("freshman",  obj.getBoolean("freshman"))
                .append("sophomore",  obj.getBoolean("sophomore"))
                .append("junior",  obj.getBoolean("junior"))
                .append("senior",  obj.getBoolean("senior"))
                .append("tags",  tags.toList())
                .append("description", obj.getString("description"));
                collection.insertOne(doc);  
                continue;          
            }
            JSONArray tags = obj.getJSONArray("tags");
            Document doc = new Document("name", obj.getString("name"))
            .append("department", obj.getString("department"))
            .append("hours", obj.getInt("hours"))
            .append("isBlended", obj.getBoolean("isBlended"))
            .append("freshman",  obj.getBoolean("freshman"))
            .append("sophomore",  obj.getBoolean("sophomore"))
            .append("junior",  obj.getBoolean("junior"))
            .append("senior",  obj.getBoolean("senior"))
            .append("prerequisites", prereq.toList())
            .append("tags",  tags.toList())
            .append("description", obj.getString("description"));
            collection.insertOne(doc);

        }

        
    }
}