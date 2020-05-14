package backend;

//import java.io.File;
//import java.io.IOException;
import backend.pages.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import backend.Server.*;

public class WebServer {
    public static void main(String[] args) {
        //Disables mongo logging
        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.SEVERE);
        int port;
        if(args.length < 1){
            port = 8000;
        }else{
            port = new Integer(args[0]);
        }
        //Open MongoDB
        Database.COLLECTION_COURSES.count();
        //start server
        Server server = new Server(port, new Path[]{ new Path("/login", "", "./backend/Pages/oauthDebug.html", Path.HTML ,true),new Path("/getSurvey", "", "./backend/Pages/survey.json", Path.TXT ,true),new Path("/getTestResults", "", "./backend/Pages/testSurveyResults.json", Path.TXT ,true), new Path("/debug", "", "./backend/Pages/debug.html", Path.HTML ,true),  new Path("/", "", "./backend/Pages/debug.html", Path.HTML ,true)}, new Post[]{new Post("/getCourses", "{}", "", Path.TXT, new getCourses()),new Post("/oauth", "{}", "", Path.TXT, new login())} );
        System.out.println("Get Survey(GET): http://localhost:8000/getSurvey\nSend Survey Results(POST) http://localhost:8000/getCourses\nGet Fake Survey Results(GET) http://localhost:8000/getTestResults\nSurvey Debugger Page http://localhost:8000/debug");
        server.start();
        //
        
    }
}