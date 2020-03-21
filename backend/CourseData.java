//Package to deal with json in java
import org.json.*;
//Reads text file
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//imports ArrayList
import java.util.ArrayList;
public class CourseData {
    //Instance Variables
    private CourseProfile[] profiles;
    //Constants
    //Subjects Avalible
    public static final String MATH = "MATH";
    public static final String ENGLISH = "ENGLISH";
    public static final String SCIENCE = "MATH";
    public static final String SOCIAL_STUDIES = "SS";
    public static final String COMPUTER_SCIENCE = "CS";
    public static final String APPLIED_TECHNOLOGY = "AT";
    public static final String BUSINESS = "BUSINESS";
    public static final String FAMILY_AND_CONSUMER_SCIENCE = "FACS";
    public static final String MCC_PARTNERSHIP_FOR_COLLEGE_AND_CAREER_SUCCESS = "PCCS";
    public static final String ENGINEERING = "ENG";
    public static final String FINE_ARTS = "ART";
    public static final String MUSIC = "MUSIC";
    public static final String PERFORMING_ARTS = "PERFORMING";
    public static final String VISUAL_ART = "VART";
    public static final String WORLD_LANGUAGE = "LANG";
    public static final String GLOBAL_ACADEMY = "GLOBAL";
    public static final String MEDICAL_ACADEMY = "MED";
    public static final String PHYSICAL_EDUCATION = "PE";

    //For No prerequisites
    public static final String NONE = "NONE";

    public static final int FRESHMAN = 9;
    public static final int SOPHOMORE = 10;
    public static final int JUNIOR = 11;
    public static final int SENIOR = 12;

    public CourseData() {
        // Reads the file with all the paths of the courses and compiles them into an array
        //Give the folder path, the path file must be name courses.json
        try {
            this.profiles = readJSON("backend/courses");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private CourseProfile readCourse(String folder, String filename) throws FileNotFoundException {
        //Holds profile obj
        CourseProfile profile;
        //Reads File
        String jsonString =  ""; 
        File file = new File(folder+"/"+filename); 
        Scanner scan = new Scanner(file); 
        while (scan.hasNextLine()){
            jsonString += scan.nextLine()+"\n";
        }
        JSONObject obj = new JSONObject(jsonString);
        JSONArray JSONprerequisites = obj.getJSONArray("prerequisites");
        //Constructs  CourseProfile from json object
        String[] prerequisites = new String[JSONprerequisites.length()];
        for(int i =0; i < JSONprerequisites.length(); i++){
            prerequisites[i] = JSONprerequisites.getString(i);
        }
        profile = new CourseProfile(obj.getString("department"), obj.getString("name"), obj.getInt("hours"), obj.getBoolean("isBlended"), obj.getBoolean("freshman"), obj.getBoolean("sophomore"), obj.getBoolean("junior"), obj.getBoolean("senior"), prerequisites, obj.getString("description"));
        return profile;
    }
    //Gets an array of CourseProfile from a json file containing the paths of every json file for each course
    private CourseProfile[] readJSON(String path) throws FileNotFoundException {
        //Temporary CourseProfile array to hold the return value
        CourseProfile[] tempProfiles;
        //Reads File
        String jsonString =  ""; 
        File file = new File(path+"/courses.json"); 
        Scanner scan = new Scanner(file); 
        while (scan.hasNextLine()){
            jsonString += scan.nextLine()+"\n";
        }
        //Parses File
        JSONObject  obj = new JSONObject(jsonString);
        //Gets the array of course paths
        JSONArray coursePaths = obj.getJSONArray("courses");
        tempProfiles = new CourseProfile[coursePaths.length()];
        for(int i = 0; i < coursePaths.length(); i++){
            tempProfiles[i] = readCourse(path,coursePaths.getString(i));
        }
        return tempProfiles;
    }
    /**
     * @return the courses
     */
    public CourseProfile[] getAllCourses() {
        return profiles;
    }
    /**
     * @return the courses that are in the given subject
     */
    public CourseProfile[] getCoursesBySubject(String subject){
        //Gets all courses that comply with subject in arraylist
        ArrayList<CourseProfile> courses = new ArrayList<CourseProfile>();
        for(CourseProfile profile: profiles){
            
            if(profile.getDepartment().equals(subject)){
                courses.add(profile);
            }
        }
        //Converts To array
        CourseProfile[] coursesArr = new CourseProfile[courses.size()];
        for(int i = 0; i < courses.size(); i++){
            coursesArr[i] = courses.get(i);
        }
        return coursesArr;
    }
    /**
     * @return the courses that match the given credit hours
     */
    public CourseProfile[] getCoursesByCredit(int creditHours){
        //Gets all courses that have the correct amount of credit hours
        ArrayList<CourseProfile> courses = new ArrayList<CourseProfile>();
        for(CourseProfile profile: profiles){
            
            if(profile.getHours() == creditHours){
                courses.add(profile);
            }
        }
        //Converts To array
        CourseProfile[] coursesArr = new CourseProfile[courses.size()];
        for(int i = 0; i < courses.size(); i++){
            coursesArr[i] = courses.get(i);
        }
        return coursesArr;
    }
    /**
     * @return the courses that match the prerequisites
     */
    public CourseProfile[] getCoursesByPrerequisites(String[] prerequisites){
        //Gets all the courses that match the prerequisites
        ArrayList<CourseProfile> courses = new ArrayList<CourseProfile>();
        for(CourseProfile profile: profiles){
            boolean meetsPrerequisites = true;
            for(String prerequisite: prerequisites){
                boolean meetsPrerequisite = false;
                for(int i = 0; i < profile.getPrerequisites().length; i++){
                    if(profile.getPrerequisites()[i].equals(prerequisite)){
                        meetsPrerequisite = true;
                    }
                }
                if(!meetsPrerequisite){
                    meetsPrerequisites = false;
                }
            }
            if(meetsPrerequisites){
                courses.add(profile);
            }
        }
        //Converts To array
        CourseProfile[] coursesArr = new CourseProfile[courses.size()];
        for(int i = 0; i < courses.size(); i++){
            coursesArr[i] = courses.get(i);
        }
        return coursesArr;
    }
        /**
     * @return the courses that need no prerequistites, use const NONE
     */
    public CourseProfile[] getCoursesByPrerequisites(String prerequisites){
        if(!prerequisites.equals(NONE)){
            //If NONE not given
            return null;
        }
        //Gets all the courses that have no prerequistites
        ArrayList<CourseProfile> courses = new ArrayList<CourseProfile>();
        for(CourseProfile profile: profiles){
            if(profile.getPrerequisites().length == 0){
                courses.add(profile);
            }
        }
        //Converts To array
        CourseProfile[] coursesArr = new CourseProfile[courses.size()];
        for(int i = 0; i < courses.size(); i++){
            coursesArr[i] = courses.get(i);
        }
        return coursesArr;
    }
    /**
     * @return the courses that meet the grade requirement
     */
    public CourseProfile[] getCoursesByGrade(int grade){
        //Gets all courses that people in the given grade can take
        ArrayList<CourseProfile> courses = new ArrayList<CourseProfile>();
        if(grade == FRESHMAN){
            for(CourseProfile profile: profiles){
                if(profile.canFreshman()){
                    courses.add(profile);
                }
            }
        }
        if(grade == SOPHOMORE){
            for(CourseProfile profile: profiles){
                if(profile.canSophomore()){
                    courses.add(profile);
                }
            }
        }
        if(grade == JUNIOR){
            for(CourseProfile profile: profiles){
                if(profile.canJunior()){
                    courses.add(profile);
                }
            }
        }
        if(grade == SENIOR){
            for(CourseProfile profile: profiles){
                if(profile.canSenior()){
                    courses.add(profile);
                }
            }
        }
        
        //Converts To array
        CourseProfile[] coursesArr = new CourseProfile[courses.size()];
        for(int i = 0; i < courses.size(); i++){
            coursesArr[i] = courses.get(i);
        }
        return coursesArr;
    }
}