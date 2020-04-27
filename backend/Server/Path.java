package Server;
//Read external files
import java.nio.file.Files;
import java.io.File;
// import java.io.*; 
public class Path{
    private String dataPath;
    private byte[] data;
    private String path;
    private String header;
    //Content Headers Avalible
    public static final String HTML = "text/html; charset=UTF-8";
    public static final String TXT = "text/plain; charset=UTF-8";
    public static final String PNG = "image/png";
    public static final String JPG = "image/jpeg";
    public static final String GIF = "image/gif";
    public static final String TFF = "image/tiff";
    public static final String MP4 = "video/mp4";
    public static final String WEBM = "video/webm";
    public static final String MP3 = "audio/mpeg";
    public static final String WAV = "audio/x-wav";

    private boolean loaded;
    // True if has external file, false if data in obj
    private boolean external;
    //Constructor, if data is empty dataPath is set, always loads
    public Path(String path, String data, String dataPath, String header){
        this.path = path;
        if(data == ""){
            this.external = true;
            this.dataPath = dataPath;
            load();
            this.loaded = true; 
        }else{
            try {
                this.data = data.getBytes("UTF-8");;
            } catch (Exception e) {
                //TODO: handle exception
            }
            this.loaded = true;
            this.external = false;

        }
        this.header = header;
    }
    //Constructor, if data is empty dataPath is set, loads if loaded true
    public Path(String path, String data, String dataPath, String header, boolean loaded){
        this.path = path;
        if(data == ""){
            this.external = true;
            this.dataPath = dataPath;
            if(loaded){
                load();
            }
            this.loaded = loaded; 
        }else{
            this.external = false;
            try {
                this.data = data.getBytes("UTF-8");
            } catch (Exception e) {
                //TODO: handle exception
            }
            this.loaded = true;
        }
        this.header = header;
    }
    //Loads data from dataPath
    public void load(){
        if(this.dataPath == ""){

        }else{
            try{
                File fi = new File(this.dataPath);
                
                try{
                    byte[] fileContent = Files.readAllBytes(fi.toPath());
                    this.data = fileContent;
                }
                catch(Throwable tr){
                    tr.printStackTrace();
                } 
            }
            catch(Throwable tr){
                tr.printStackTrace();
            }
            
    }
}
    //Switches data path and loads
    
    public void load(String dataPath){
        this.external = true;
        this.dataPath = dataPath;
        try{
            File fi = new File(this.dataPath);
            
            try{
                byte[] fileContent = Files.readAllBytes(fi.toPath());
                this.data = fileContent;
            }
            catch(Throwable tr){
                tr.printStackTrace();
            } 
        }
        catch(Throwable tr){
            tr.printStackTrace();
        }
        
    }
    /**
     * @return the dataPath
     */
    public String getDataPath(){
        return this.dataPath;
    }
    /**
     * @return the data
     */
    public byte[] getData(){
        return this.data;
    }
    //Sets the data to be sent if literal
    public void setData(String data){
        try {
            this.data = data.getBytes("UTF-8");
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    /**
     * @return the path
     */
    public String getPath(){
        return this.path;
    }
    /**
     * @return the header
     */
    public String getHeader(){
        return this.header;
    }
    /**
     * @return true if a external file is used for data
     */
    public boolean isExternal(){
        return this.external;
    }
    /**
     * @return if the external file is loaded
     */
    public boolean isLoaded(){
        return this.loaded;
    }
}