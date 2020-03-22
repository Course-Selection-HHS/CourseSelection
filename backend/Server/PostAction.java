package Server;
//This interface is used to create classes that are referenced when a Post request is requested
public interface PostAction{
    void action(String responce);
    Path sendResponce();
}