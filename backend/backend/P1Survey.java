
/*
// THIS IS THROWING ERRORS, apparently this file is not in use
package backend;

import java.util.*;
public class P1Survey {
  private String[] quest2;//Questions for rating qestions
  private String[] q2Tags;//Tags for those questions
  public P1Survey() {
    String[] q = {"I want blended classes", "I want AP classes", "I want to code", "I want to use technology", "I want to make food", "I want to be in theaters", "I like to engineer structors", "I like sports", "I like the business side of things", "I like to make art", "I like to look in style", "I like music", "I would like to learn a 2nt language", "I would like to learn Spanish", "I would like to learn Chinese", "I would like to learn French", "I would like to learn about medicine", "I would like to learn about our government", "I would like to learn about other countries"};
    quest2 = q;
    String[] t = {"blended", "ap", "coding", "technology", "food", "theatre", "engineering", "sports", "marketing", "art", "fashion", "music", "2ndLanguage", "spanish", "chinese", "french", "medical", "government", "global"};
    q2Tags = t;
  }
  public void takeSurvey() {
    Scanner scan = new Scanner(System.in);
    ArrayList<Checklist> quest1 = new ArrayList<Checklist>();//Makes an array for all the checklist questions
    quest1.add(new Checklist(1, "Listen to music\nMake food\nPlay sports\nDraw pictures"));
    quest1.add(new Checklist(2, "Structures made of wood\nA cure for a disease\nAn innovative design for a shirt"));
    quest1.add(new Checklist(3, "How to code\nHow to act\nHow the government works\nHow to speak another language"));
    quest1.add(new Checklist(4, "Spanish\nChinese\nFrench"));
    quest1.add(new Checklist(5, "Be AP\nBe blended"));
    quest1.add(new Checklist(6, "Living in another country\nWorking with technology\nMarketing a new product"));
    String[] questions = {"In my freetime I like to...", "I would like to make...", "I would like to learn…", "I am interested in learning...", "I like my classes to...", "I could see myself in the future..."};//Questions for the checklist
    ArrayList<String> tags = new ArrayList<String>();//Associated tags
    for (int i = 0; i < quest1.size(); i++) {
      System.out.println(questions[i]);
      String[] q1Tags = quest1.get(i).getTags();
      for (int j = 0; j < q1Tags.length; j++) {
        boolean used = false;
        for (int k = 0; k < tags.size(); k++) {
          if (q1Tags[j].equals(tags.get(k))) {//Makes sure there is only one
            used = true;
          }
        }
        if (!used) {
          tags.add(q1Tags[j]);
        }
      }
    }
    //Asks rating for those questions
    Rating[] finalTags = new Rating[tags.size()];
    System.out.println("Rate the following from 1 to 10");
    for (int i = 0; i < q2Tags.length; i++) {
      for (int j = 0; j < tags.size(); j++) {
        if (tags.get(j).equals(q2Tags[i])) {
          System.out.println(quest2[i]);
          finalTags[j] = new Rating(scan.nextInt(), quest2[i]);
        }
      }
    }
  }
}
*/