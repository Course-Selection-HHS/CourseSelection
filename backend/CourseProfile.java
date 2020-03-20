public class CourseProfile{
    private String department;
    private String name;
    private int hours;
    private boolean blended;
    private boolean freshman;
    private boolean sophomore;
    private boolean junior;
    private boolean senior;
    private String[] prerequisites;
    private String description;
    public CourseProfile(String department, String name, int hours, boolean blended, boolean freshman, boolean sophomore, boolean junior, boolean senior, String[] prerequisites, String description){
        //Initilizes every instance var
        this.department = department;
        this.name = name;
        this.hours = hours;
        this.blended = blended;
        this.freshman = freshman;
        this.sophomore = sophomore;
        this.junior = junior;
        this.senior = senior;
        this.prerequisites = prerequisites;
        this.description = description;
    }
    //Getters
    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the hours
     */
    public int getHours() {
        return hours;
    }
    /**
     * @return the blended
     */
    public boolean isBlended() {
        return blended;
    }
    /**
     * @return if freshman can take course
     */
    public boolean canFreshman() {
        return freshman;
    }
    /**
     * @return if sophomore can take course
     */
    public boolean canSophomore() {
        return sophomore;
    }
    /**
     * @return if junior can take course
     */
    public boolean canJunior() {
        return junior;
    }
    /**
     * @return if senior can take course
     */
    public boolean canSenior() {
        return senior;
    }
    /**
     * @return the prerequisites
     */
    public String[] getPrerequisites() {
        return prerequisites;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
}