package backend;

import java.util.Locale;

import com.mongodb.client.model.Filters;

import org.bson.Document;

public class SessionID {
    private String id;
    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String lower = upper.toLowerCase(Locale.ROOT);
    public static final int[] digits = {0,1,2,3,4,5,6,7,8,9};
    //Creates new Session ID
    public SessionID(){
        this.id = this.genID(14);
    }
    //Create Session ID with predetermined id
    public SessionID(String id){
        this.id = id;
    }
    //Create Session ID and sets it to the User
    public SessionID(User user){
        this.id = this.genID(14);
        try {
            Database.COLLECTION_USERS.updateOne(Filters.eq("username", user.getUsername()), new Document("$set", new Document("sessionID", this.id)));
        } catch (Exception e) {
            System.out.println("Username not found");
            e.printStackTrace();
        }
    }
    private String genID(int length) {
        String tempID = "";
        for(int i = 0; i < length; i++){
            int type = (int)(Math.random() * 3);
            if(type == 0){
                tempID += randomUpper();
            }
            if(type == 1){
                tempID += randomLower();
            }
            if(type == 2){
                tempID += randomDigit();
            }
        }
        return tempID;
    }
    private String randomUpper(){
        int index = (int)(Math.random() * SessionID.upper.length());
        return SessionID.upper.substring(index, index+1);
    }
    private String randomLower(){
        int index = (int)(Math.random() * SessionID.lower.length());
        return SessionID.lower.substring(index, index+1);
    }
    private String randomDigit(){
        int index = (int)(Math.random() * SessionID.digits.length);
        return ""+SessionID.digits[index];
    }
    //Static method to check if id exists and is valid
    public static boolean validateSessionID(String id){
        try {
            if(( Database.COLLECTION_USERS.count(Filters.eq("sessionID", id))) > 0){
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
   
}