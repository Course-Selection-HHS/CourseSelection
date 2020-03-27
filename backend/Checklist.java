import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.*;

public class Checklist extends Question {

    public Checklist(int id, String ans) {
        super(id, "Checklist", ans);
    }

    public String[] getTags() throws FileNotFoundException {
        String answerString =  ""; 
        File file = new File("backend/ChecklistAnswers/" + super.getQuestionID() + ".json"); 
        Scanner scan = new Scanner(file); 
        while (scan.hasNextLine()){
            answerString += scan.nextLine()+"\n";
        }
        JSONObject obj = new JSONObject(answerString);
        JSONArray arrayOfCheckmarks = obj.getJSONArray("answers");

        obj = new JSONObject(super.getAnswer());
        JSONArray arrayOfAnswers = obj.getJSONArray("checklist");

        ArrayList<String> tags = new ArrayList<String>();
        for(int i = 0; i < arrayOfAnswers.length(); i++){
            if(arrayOfAnswers.getInt(i) == 1){
                tags.add(arrayOfCheckmarks.getString(i));
            }
        }
        ArrayList<String> tagsFinal = new ArrayList<String>();
        for(int i = 0; i < tags.size(); i++){
            if(!tagsFinal.contains(tags.get(i))){
                tagsFinal.add(tags.get(i));
            }
        }
        String[] allTags = new String[tagsFinal.size()];
        for(int i = 0; i < allTags.length; i++){
            allTags[i] = tagsFinal.get(i);
        }
        return allTags;
    }


}