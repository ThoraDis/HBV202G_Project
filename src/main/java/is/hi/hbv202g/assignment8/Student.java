package is.hi.hbv202g.assignment8;

/**
 * A student in the library system
 */
public class Student extends User{
    private boolean feePaid;

    /**
     * Constructor for student
     * 
     * @param name the name of the student
     * @param feePaid if a student has paid their late fee
     */
    public Student(String name, boolean feePaid){
        super(name);
        this.feePaid=feePaid;
    }

    /**
     * Gets isFeePaid
     * 
     * @return true if student has a feepaid but false if fee is unpaid
     */
    public boolean isFeePaid(){
        return this.feePaid;
    }

    /**
     * Sets new boolean isFeePaid
     * 
     * @param feePaid the boolean value if the fee is paid
     */
    public void setFeePaid(boolean feePaid){
        this.feePaid=feePaid;
    }

}
