package backend.TestingTools;

import com.mongodb.client.model.Filters;

import org.bson.Document;

import backend.Database;
import backend.User;

public class createNewUser {
    public static void main(String[] args){

        User newUser = new User("belin@district158.org", "Marcus Belin");
        System.out.println(newUser.getSessionID());
        
    }
}