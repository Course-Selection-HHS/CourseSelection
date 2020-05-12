package backend.TestingTools;


import backend.User;

public class createNewUser {
    public static void main(String[] args){
        
        User newUser = new User("belin@district158.org");
        System.out.println(newUser.getSessionID());
        newUser.changeName("Dr. Marcus Belin");
    }
}