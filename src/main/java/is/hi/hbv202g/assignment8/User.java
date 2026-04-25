package is.hi.hbv202g.assignment8;

/**
 * A user in the library system can be a a student or facultymember
 */
public abstract class User {
    private String name;

    /**
     * Constructor for user
     * 
     * @param name the name of the user
     */
    public User(String name){
        this.name=name;
    }

    /**
     * Get name of user
     * 
     * @return the users name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Set a new name for user
     * 
     * @param name the new name for user
     */
    public void setName(String name){
        this.name=name;
    }

}
