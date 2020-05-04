import java.util.ArrayList;

public class P1FinalList {
    
    //Returns an array of the classes in order of highest to lowest
    //if ap got a rating of 4 and blended 5 then put [ap, blended], [4, 5]
    public static CourseProfile[] getClasses(String[] tags, int[] rating) {
        //Gets all potential classes
        
        ArrayList<CourseProfile> all = new ArrayList<CourseProfile>();
        CourseData cd1 = new CourseData();
        for (int i = 0; i < tags.length; i++) {
            CourseData cd = cd1.getCoursesByTag(tags[i]);
            boolean[] used = new boolean[cd.getAllCourses().length];
            for (int j = 0; j < cd.getAllCourses().length; j++) {
                for (int k = 0; k < all.size(); k++) {
                    if (cd.getAllCourses()[j].getName().equals(all.get(k).getName())) {
                        used[j] = true;
                    }
                }
            }
            for (int j = 0; j < cd.getAllCourses().length; j++) {
                if (!used[j]) {
                    all.add(cd.getAllCourses()[j]);
                }
            }
        }
        //Sorts classes by rating
        int[] classRating = new int[all.size()];
        for (int i = 0; i < all.size(); i++) {
            for (int j = 0; j < all.get(i).getTags().length; j++) {
                for (int k = 0; k < tags.length; k++) {
                    if (all.get(i).getTags()[j].equals(tags[k])) {
                        classRating[i]+=rating[k];
                    }
                }
            }
            classRating[i]/=all.get(i).getTags().length;
        }
        //Makes final list of classes
        CourseProfile[] classes = new CourseProfile[all.size()];
        for (int i = 0; i < all.size(); i++) {
            int max = 0;
            for (int j = 1; j < all.size(); j++) {
                if (classRating[max] < classRating[j]) {
                    max = j;
                }
            }
            classRating[max] = -1;
            classes[i] = all.get(max);
        }
        return classes;
    }
}