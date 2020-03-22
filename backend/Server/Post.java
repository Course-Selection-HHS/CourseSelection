package Server;
public class Post extends Path{
    private String responce;
    private PostAction action;
    public Post(String path, String data, String dataPath, String header, PostAction action){
        super(path, data, "{}", "application/json");
        this.responce = "";
        this.action = action;

    }
    //These classes are used mainly only in Server and deal with creating contextes
    
    //Sets the response string passed into the PostAction, this method should be used when creating server contextes
    public void setResponce(String responce){
        this.responce = responce;
    }
    //Calls the PostAction action method
    public void doAction(Server server){
        this.action.action(this.responce, server);
    }
    //returns the Post response to the request 
    public byte[] getResponce(){
        return action.sendResponce().getData();
    }

    

}
