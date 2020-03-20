public class Recommend {
  private Courses[] allCourses;
  private int[] value;

  public Recommend() {
    Courses[] all = {new Courses("1111", "Concert Band", false, true, 1.0, "music", "create", 7, 3),
    new Courses("0011", "AP Music History", false, true, 1.0, "music", "ap", 6, 4),
    new Courses("1111", "Computer Programming", true, true, .5, "computer", "blended", 5, 5),
    new Courses("1111", "AP Computer Science Principals", false, true, 1.0, "computer", "ap", 6, 4),
    new Courses("0011", "Advanced Computer Science Principals", false, true, 1.0, "computer", "create", 6, 4)};
    allCourses = all;
    value = new int[all.length];
    sort();
  }
  
  public void sort() {
    for (int i = 0; i < allCourses.length; i++) {
      int total = 0;
      if (allCourses[i].getSubject1().equals("computer")) {
        total+=allCourses[i].getSub1Credits()*Main.sur.computer;
      }
      else if (allCourses[i].getSubject1().equals("music")) {
        total+=allCourses[i].getSub1Credits()*Main.sur.music;
      }
      else if (allCourses[i].getSubject1().equals("ap")) {
        total+=allCourses[i].getSub1Credits()*Main.sur.ap;
      }
      else if (allCourses[i].getSubject1().equals("blended")){
        total+=allCourses[i].getSub1Credits()*Main.sur.blended;
      }
      else if (allCourses[i].getSubject1().equals("create")) {
        total+=allCourses[i].getSub1Credits()*Main.sur.create;
      }
      if (allCourses[i].getSubject2().equals("computer")) {
        total+=allCourses[i].getSub2Credits()*Main.sur.computer;
      }
      else if (allCourses[i].getSubject2().equals("music")) {
        total+=allCourses[i].getSub2Credits()*Main.sur.music;
      }
      else if (allCourses[i].getSubject2().equals("ap")) {
        total+=allCourses[i].getSub2Credits()*Main.sur.ap;
      }
      else if (allCourses[i].getSubject2().equals("blended")){
        total+=allCourses[i].getSub2Credits()*Main.sur.blended;
      }
      else if (allCourses[i].getSubject2().equals("create")) {
        total+=allCourses[i].getSub2Credits()*Main.sur.create;
      }
      value[i] = total;
    }
  }
/*
  public Survey sur = new Survey();
  public Courses cou = new Courses();
    computer = 5;
    music = 5;
    ap = 5;
    blended = 5;
    create = 5;
*/
  public void top() {
    sort();
    int best = 0;
    for (int i = 1; i < allCourses.length; i++) {
      if (value[i] > value[best]) {
        best = i;
      }
    }
    System.out.println("\nYou will most likely like " + allCourses[best].getName() + "\n");
  }
}