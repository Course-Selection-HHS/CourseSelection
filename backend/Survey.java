import java.util.*;
public class Survey {
  public int computer;
  public int music;
  public int ap;
  public int blended;
  public int create;

  public Survey() {
    computer = 5;
    music = 5;
    ap = 5;
    blended = 5;
    create = 5;
  }
  
  public void takeSurvey() {
    Scanner scan = new Scanner(System.in);
    System.out.println("\nOn a scale of 1 to 10, rate these activities");
    System.out.println("I like computers");
    computer = scan.nextInt();
    scan.nextLine();
    System.out.println("I like music");
    computer = scan.nextInt();
    scan.nextLine();
    System.out.println("I like AP classes");
    computer = scan.nextInt();
    scan.nextLine();
    System.out.println("I like blended classes");
    computer = scan.nextInt();
    scan.nextLine();
    System.out.println("I like creating things");
    computer = scan.nextInt();
    scan.nextLine();
    System.out.println("");
  }
}