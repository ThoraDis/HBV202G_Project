package is.hi.hbv202g.assignment8;

/**
 * Excpetion thrown when method expects a user or book but finds either empty
 */
public class UserOrBookDoesNotExistException extends Exception {
    
    /**
     * Constructor for UserOrBookDoesNotExistException
     * @param message the message explaining cause of the exception
     */
    public UserOrBookDoesNotExistException(String message){
        super(message);
    }


}
