package backend.pages;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import org.json.*;

import backend.User;
import backend.Server.*;

public class login implements PostAction {
    private Path postResponce;
    private final String GOOGLE_CLIENT_ID = "1067755850474-iuoregvu95v7euiujp7e9fe99vp0kc6m.apps.googleusercontent.com";
    public Path sendResponce() {
        return postResponce;
    }
    
    public void action(String request, Server server) {
        //System.out.println(request);
        JSONObject loginAttempt = new JSONObject(request);
        if(loginAttempt.getString("method").equals("google")){
            loginWithGoogle(loginAttempt);
        }else{
            returnFailed();
        }
    }

    private void loginWithGoogle(JSONObject loginAttempt){
        String token = loginAttempt.getString("token");
        JSONObject oauthResponce; 
        try {
            oauthResponce = new JSONObject(get("https://www.googleapis.com/oauth2/v3/tokeninfo?access_token="+token));
        } catch (Exception e) {
            returnFailed();
            return;
        }
        
        try {
            oauthResponce.getString("error_description");
            returnFailed();
            return;
        } catch (JSONException e) {
        }
        if(!oauthResponce.getString("azp").equals(GOOGLE_CLIENT_ID)){
            returnFailed();
            return;
        }
        String username = oauthResponce.getString("email");
        String name = loginAttempt.getString("name");

        User currentUser;
        if(User.doesUserExist(username)){
            currentUser = new User(username);
        }else{
            currentUser = new User(username, name);
        }
        String sessionID = currentUser.getSessionID();
        JSONObject sucessfulGoogleResponce = new JSONObject();
        sucessfulGoogleResponce.put("success", true);
        sucessfulGoogleResponce.put("name", name);
        sucessfulGoogleResponce.put("username", username);
        sucessfulGoogleResponce.put("sessionID", sessionID);
        postResponce = new Path("/respond", sucessfulGoogleResponce.toString(), "", Path.TXT);

    }
    private void returnFailed(){
        System.out.println("Failed oauth");
        JSONObject failedResponce = new JSONObject();
        failedResponce.put("sucess", false);
        postResponce = new Path("/respond", failedResponce.toString(), "", Path.TXT);
    }
    private String get(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
           result.append(line);
        }
        rd.close();
        return result.toString();
     }
     
}
