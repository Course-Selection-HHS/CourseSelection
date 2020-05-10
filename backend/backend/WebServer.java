package backend;

import java.io.File;
import java.io.IOException;

import backend.Server.*;

public class WebServer {
    public static void main(String[] args) {
        int port;
        if(args.length < 1){
            port = 8000;
        }else{
            port = new Integer(args[0]);
        }
        Server server = new Server(port, new Path[]{new Path("/getSurvey", "", "./backend/Pages/survey.json", Path.TXT ,true),new Path("/getTestResults", "", "./backend/Pages/testSurveyResults.json", Path.TXT ,true), new Path("/debug", "", "./backend/Pages/debug.html", Path.HTML ,true),  new Path("/", "", "./backend/Pages/debug.html", Path.HTML ,true)}, new Post[]{new Post("/getCourses", "{}", "", Path.HTML, new getCourses())} );
        System.out.println("Get Survey(GET): http://localhost:8000/getSurvey\nSend Survey Results(POST) http://localhost:8000/getCourses\nGet Fake Survey Results(GET) http://localhost:8000/getTestResults\nSurvey Debugger Page http://localhost:8000/debug");
        server.start();
        //
        
    }
}