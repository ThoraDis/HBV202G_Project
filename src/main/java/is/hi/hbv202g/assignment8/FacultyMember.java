package is.hi.hbv202g.assignment8;

/**
 * A faculty member in the library system
 */
public class FacultyMember extends User {
    private String department;

    /**
     * Constructor for FacultyMember
     * 
     * @param name the name of the FacultyMember
     * @param department the name of the department of the FacultyMember
     */
    public FacultyMember(String name, String department){
        super(name);
        this.department=department;

    }

    /**
     * Get the FacultyMembers department
     * 
     * @return the name of the FacultyMembers department
     */
    public String getDepartment(){
        return this.department;

    }

    /**
     * Sets the new department of the FacultyMember
     * 
     * @param department the name of the department
     */
    public void setDepartment(String department){
        this.department=department;
        

    }

}
