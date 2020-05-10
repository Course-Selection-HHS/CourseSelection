package backend;

// import java.io.FileWriter;
import backend.Server.*;
import org.json.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class getCourses implements PostAction {
    private Path postResponce;

    public Path sendResponce() {
        return postResponce;
    }

    public void action(String request, Server server) {
        JSONObject json = new JSONObject(request);
        JSONArray answers = json.getJSONArray("answers");
        Question[] questions = new Question[answers.length()];
        ArrayList<String> tags = new ArrayList<String>();
        for (int i = 0; i < answers.length(); i++) {
            JSONObject answer = answers.getJSONObject(i);
            Question question;
            
            if(answer.getString("type").equals("checklist") || answer.getString("type").equals("tf") || answer.getString("type").equals("multi")){
                //Checklist needs a json array string as its answer so this converts it

                JSONArray checklistAnswerAray = answer.getJSONArray("answer");
                JSONObject checklistAnswer = new JSONObject();
                checklistAnswer.put("checklist", checklistAnswerAray);
                System.out.println(checklistAnswer.toString());
                question = new Question(answer.getInt("id"), answer.getString("type"), checklistAnswer.toString());
            }else{
                question = new Question(answer.getInt("id"), answer.getString("type"), answer.getString("answer"));
            }
            questions[i] = question;
        }
        for (Question question : questions) {

            if (question.getQuestionType().equals("checklist")) {
                Checklist checklist = new Checklist(question.getQuestionID(), question.getAnswer());
                String[] newTags;

                try {
                    newTags = checklist.getTags();
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    newTags = new String[]{};
                }
                for(String tag: newTags){
                    tags.add(tag);
                }
            }
        }
        //convert to string[]
        String[] tagsArr = new String[tags.size()];
        for(int i = 0; i < tags.size(); i++){
            tagsArr[i] = tags.get(i);
        }
        int[] allRating5 = new int[tagsArr.length];
        for(int i = 0; i < allRating5.length; i++){
            allRating5[i] = 5;
        }
        CourseProfile[] courses = P1FinalList.getClasses(tagsArr, allRating5);

        JSONObject responceObj = new JSONObject();
        JSONArray courseArr = new JSONArray();
        System.out.println(courses.length);
        for(CourseProfile course: courses){
            courseArr.put(course.getName());
            System.out.println(course.getName());
        }
        responceObj.put("courses", courseArr);
        this.postResponce = new Path("/getCourses",responceObj.toString(), "", Path.TXT);

        
    }
}