package backend;

public class Rating{
    public int score;
    public String question;

    public Rating(int sc, String quest) {
        score = sc;
        question = quest;
    }

    public int getScore() {
        return score;
    }

    public String getQuestion() {
        return question;
    }

    public String getTag() {
        if (score > 5)
            return question;
        else
            return "false";
    }
}