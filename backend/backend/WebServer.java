package backend;
import backend.Server.*;
public class WebServer {
    public static void main(String[] args){
        int port = 8000;
        if(args[0] != null){
            port = Integer.parseInt(args[0]);
        }
        Server server = new Server(port, new Path[]{new Path("/getSurvey", "", "backend/pages/survey.json", Path.TXT ,true),new Path("/getTestResults", "", "backend/pages/testSurveyResults.json", Path.TXT ,true), new Path("/debug", "", "backend/pages/debug.html", Path.HTML ,true),  new Path("/", "", "backend/pages/debug.html", Path.HTML ,true)}, new Post[]{new Post("/getCourses", "{}", "", Path.HTML, new getCourses())} );
        System.out.println("Get Survey(GET): http://localhost:8000/getSurvey\nSend Survey Results(POST) http://localhost:8000/getCourses\nGet Fake Survey Results(GET) http://localhost:8000/getTestResults\nSurvey Debugger Page http://localhost:8000/debug");
        server.start();
    }
}