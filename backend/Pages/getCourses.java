package Pages;
import java.io.FileWriter;
import Server.*;


public class getCourses implements PostAction{
    private Path postResponce;
    public Path sendResponce(){
        return postResponce;
    } 
    public void action(String request, Server server){
        System.out.println(request);
        server.addPath(new Path("/123456", "COMP SCI, IED, COMP SCI PRINCIPLES", "", Path.TXT));
        postResponce = new Path("/123456","/123456", "", Path.TXT ,true);
        
    }
}