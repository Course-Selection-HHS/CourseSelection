package backend.Server;
//This interface is used to create classes that are referenced when a Post request is requested
public interface PostAction{
    void action(String request, Server server);
    Path sendResponce();
}