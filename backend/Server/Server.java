package Server;
//Webserver library
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.*;
//Read Files
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
//Setting up the port
import java.net.InetSocketAddress;
public class Server{
    private int port;
    private Path[] paths;
    private Post[] posts;
    private HttpServer server;
    public Server(int port, Path[] paths, Post[] posts){
        this.port = port;
        this.paths = paths;
        this.posts = posts;
        //Creates server at port if fails print stack trace
        try{
            this.server = HttpServer.create(new InetSocketAddress(this.port), 0);
        }catch (Throwable tr)
        {
            tr.printStackTrace();
        }
        //Adds every path in path array
        for(Path path: this.paths){
            server.createContext(path.getPath(), httpExchange ->
            {
                //Allows CORS
                httpExchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*"); 
                byte response[]= path.getData();
                httpExchange.getResponseHeaders().add("Content-Type", path.getHeader());
                httpExchange.sendResponseHeaders(200, response.length);

                OutputStream out=httpExchange.getResponseBody();
                out.write(response);
                out.close();
            });

                
            }
        //Adds Every Post in post array
        for(Post post : this.posts){
            server.createContext(post.getPath(), httpExchange ->{
                //Allows CORS
                httpExchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
                StringBuilder sb = new StringBuilder();
                InputStream in = httpExchange.getRequestBody();
                int i;
                while ((i = in.read()) != -1) {
                    sb.append((char) i);
                }
                post.setResponce(sb.toString());
                post.doAction();
                byte[] response = post.getResponce();
                httpExchange.sendResponseHeaders(200, response.length);
                OutputStream os = httpExchange.getResponseBody();
                os.write(response);
                os.close();
            });
        }
    }
    //Adds a Path to the server context
    public void addPath(Path path){
        server.createContext(path.getPath(), httpExchange ->
            { 
                //Allows CORS
                httpExchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
                byte response[]= path.getData();
                httpExchange.getResponseHeaders().add("Content-Type", path.getHeader());
                httpExchange.sendResponseHeaders(200, response.length);

                OutputStream out=httpExchange.getResponseBody();
                out.write(response);
                out.close();
            });
    }
    //Adds a Post to the server context
    public void addPost(Post post){
        server.createContext(post.getPath(), httpExchange ->{
            //Allows CORS
            httpExchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
            StringBuilder sb = new StringBuilder();
            InputStream in = httpExchange.getRequestBody();
            int i;
            while ((i = in.read()) != -1) {
                sb.append((char) i);
            }
            post.setResponce(sb.toString());
            post.doAction();
            byte[] response = post.getResponce();
            httpExchange.sendResponseHeaders(200, response.length);
            OutputStream os = httpExchange.getResponseBody();
            os.write(response);
            os.close();
        });
    }
    //Starts the server
    public void start(){
        this.server.start();
    }
    //Loads every file in the given folder and each subfolder with the url path /+folderPath+filePath
    //Use relevant path for url
    public void loadAssests(String folderPath){
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("/"+folderPath+""+listOfFiles[i].getName());
                addPath(new Path("/"+folderPath+""+listOfFiles[i].getName(), "", listOfFiles[i].getAbsolutePath(), getTypeByFile(listOfFiles[i]), true));
            } else if (listOfFiles[i].isDirectory()) {
                loadAssests(folderPath+listOfFiles[i].getName()+"/");
            }
        }
    }
    //Loads every file in the given folder and each subfolder with the url path starting at root 
    //Use root as root of url tree
    public void loadAssests(String folderPath, String root){
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println(root+""+listOfFiles[i].getName());
                addPath(new Path(root+""+listOfFiles[i].getName(), "", listOfFiles[i].getAbsolutePath(), getTypeByFile(listOfFiles[i]), true));
            } else if (listOfFiles[i].isDirectory()) {
                loadAssests(folderPath+"/"+listOfFiles[i].getName(), root+listOfFiles[i].getName()+"/");
            }
        }
    }
    //Figures out what sort of header a file should have for loadAssests
    private String getTypeByFile(File file){
        String path = file.getName();
        String extention = "";
        for(int i = path.length()-1; i >= 0; i--){
            if(path.substring(i, i+1).equals(".")){
                extention = path.substring(i);
                break;
            }
        }
        if(extention.equals(".png")){
            return Path.PNG;
        }
        else if(extention.equals(".jpeg") || extention.equals(".jpg")){
            return Path.JPG;
        }
        else if(extention.equals(".gif")){
            return Path.GIF;
        }
        else if(extention.equals(".tff") || extention.equals(".tiff")){
            return Path.TFF;
        }
        else if(extention.equals(".mp4") || extention.equals(".mpeg4")){
            return Path.MP4;
        }
        else if(extention.equals(".webm")){
            return Path.WEBM;
        }
        else if(extention.equals(".mp3") || extention.equals(".mpeg3")){
            return Path.MP3;
        }
        else if(extention.equals(".wav")){
            return Path.WAV;
        }
        else{
            return Path.TXT;
        }
        

    }
}


