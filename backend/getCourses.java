// import java.io.FileWriter;
import Server.*;
import org.json.*;
public class getCourses implements PostAction{
    private Path postResponce;
    public Path sendResponce(){
        return postResponce;
    } 
    public void action(String request, Server server){
        JSONObject json = new JSONObject(request);
        JSONArray answers = json.getJSONArray("answers");
        Question[] questions = new Question[answers.length()];
        for(int i = 0; i < answers.length(); i++){
            JSONObject answer = answers.getJSONObject(i);
            Question question = new Question(answer.getInt("id"), answer.getString("type"), answer.getString("answer"));
            questions[i] = question;
        }
        //QuestionHandler courses = new QuestionHandler(questions);
        

        
    }
}