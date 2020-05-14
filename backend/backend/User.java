package backend;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import org.bson.Document;

public class User {
    private String username;
    private String name;
    private SessionID sessionID;
    //Get Active user with username or session
    public User(String loginCredendials){
        if(loginCredendials.contains("@")){
            getUserByUsername(loginCredendials);
        }else{
            getUserBySessionID(loginCredendials);
        }

        
    }
    //Used when session ID is provided to construct
    private void getUserBySessionID(String loginCredendials) {
        this.sessionID = new SessionID(loginCredendials);
        try {
            this.username = (String)Database.COLLECTION_USERS.find(Filters.eq("sessionID", this.sessionID.getId())).first().get("username");
        } catch (Exception e) {
            System.out.println("SessionID Not found");
            e.printStackTrace();
        }
        try {
            this.name = (String)Database.COLLECTION_USERS.find(Filters.eq("sessionID", this.sessionID.getId())).first().get("name");
        } catch (Exception e) {
            System.out.println("SessionID Not found");
            e.printStackTrace();
        }
    }
    //Used when username is provided to construct
    private void getUserByUsername(String username) {
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
    //Deletes this user from server
    public void delete(){
        Database.COLLECTION_USERS.deleteOne(Filters.eq("username", this.username));
    }
    //Changes the name of this user
    public void changeName(String newName){
        Database.COLLECTION_USERS.updateOne(Filters.eq("username", this.getUsername()), new Document("$set", new Document("name", newName)));    
        this.name = newName;
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
    public static boolean doesUserExist(String testUsername){
        
        try {
            if(( Database.COLLECTION_USERS.count(Filters.eq("username", testUsername))) > 0){
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

       
    }

}