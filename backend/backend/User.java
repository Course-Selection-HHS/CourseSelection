package backend;

import java.io.Console;

import com.mongodb.client.model.Filters;

import org.bson.Document;

public class User {
    private String username;
    private String name;
    private SessionID sessionID;
    //Get Active user with username
    public User(String username){
        this.username = username;
        try {
            this.name = (String)Database.COLLECTION_USERS.find(Filters.eq("username", this.username)).first().get("name");
        } catch (Exception e) {
            System.out.println("Username not found");
            e.printStackTrace();

        }
        this.sessionID = new SessionID(this);
    }
    //Create new User 
    public User(String username, String name){
        this.username = username;
        this.name = name;
        Document newUser = new Document("username",this.username)
            .append("name", this.name)
            .append("sessionID", "");
        Database.COLLECTION_USERS.insertOne(newUser);
        this.sessionID = new SessionID(this);

    }
    //Creates a new sessionID and updates it in database
    public void generateNewSessionID(){
        this.sessionID = new SessionID(this);
    }
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }  
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the sessionID
     */
    
    public String getSessionID() {
        return sessionID.getId();
    }

}