import java.util.*;
public class Courses {
  private String openToGrades, name;
  private boolean blended, elective;
  private double credit;
  private String subject1, subject2;
  private int sub1Credits, sub2Credits;

  public Courses(String ops, String nam, boolean bld, boolean ele, double crt, String sub1, String sub2, int subc1, int subc2) {
    openToGrades = ops;
    name = nam;
    blended = bld;
    elective = ele;
    credit = crt;
    subject1 = sub1;
    subject2 = sub2;
    sub1Credits = subc1;
    sub2Credits = subc2;
  }
  
  public ArrayList<String> getGrades() {
    //Seniors Juniors Sophmors Freshmen
    //  1/0     1/0      1/0     1/0
    //1 = true // 0 = false
    ArrayList<String> str = new ArrayList<String>();
    
    if (openToGrades.substring(0,1).equals("1")) {
      str.add("Seniors");
    }
    if (openToGrades.substring(1,2).equals("1")) {
      str.add("Juniors");
    }
    if (openToGrades.substring(2,3).equals("1")) {
      str.add("Sophmors");
    }
    if (openToGrades.substring(3,4).equals("1")) {
      str.add("Freshmen");
    }

    return str;
  }
  
  public String getName() {
    return name;
  }

  public boolean getBlended() {
    return blended;
  }

  public boolean getElective() {
    return elective;
  }

  public double getCredit() {
    return credit;
  }

  public String getSubject1() {
    return subject1;
  }

  public String getSubject2() {
    return subject2;
  }

  public int getSub1Credits() {
    return sub1Credits;
  }

  public int getSub2Credits() {
    return sub2Credits;
  }
}