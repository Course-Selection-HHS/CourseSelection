import java.util.*;
class Main {
  public static Survey sur = new Survey();

  public static void main(String[] args) {
    mainMenu();
  }

  public static void mainMenu() {
    Scanner scan = new Scanner(System.in);
    Recommend rec = new Recommend();
    boolean run = true;
 
    while (run) {
      System.out.println("What would you like to do?\n\tType \"survey\" to type answers to a survey.\n\tType \"results\" to get the results for your best suited course for you\n\tType \"catalog\" for every course\n\tType \"end\" to leave");
      String responce = scan.nextLine();
      if (responce.toLowerCase().equals("survey")) {
        sur.takeSurvey();
      }
      else if (responce.toLowerCase().equals("results")) {
        rec.top();
      }
      else if (responce.toLowerCase().equals("catalog")) {
        System.out.println  ("\nhttp://www.district158.org/weblinks/files/hhs/CourseCatalog2020-2021.pdf\n");
      }
      else if (responce.toLowerCase().equals("end")) {
        run = false;
      }
      else {
        System.out.println("\nSorry that was not an option\n");
      }
    }
  }
}