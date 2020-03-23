import Server.*;
public class WebServer{
    public static void main(String[] args){
        Server server = new Server(8000, new Path[]{new Path("/getSurvey", "", "backend/pages/survey.json", Path.TXT ,true)}, new Post[]{new Post("/getCourses", "{}", "", Path.HTML, new getCourses())} );
        server.start();
    }
}