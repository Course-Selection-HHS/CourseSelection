package backend;

public class Question{

    private String  questionType, answer;
    private int questionID;
    public Question(int questionID, String questionType, String answer){
        this.questionID = questionID;
        this.questionType = questionType;
        this.answer = answer;
    }
  
    /**
     * @return the questionID
     */
    public int getQuestionID() {
        return questionID;
    }
    
    /**
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @return the questionType
     */
    public String getQuestionType() {
        return questionType;
    }

    /**
     * @param questionID the questionID to set
     */
    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    /**
     * @param questionType the questionType to set
     */
    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }    
}