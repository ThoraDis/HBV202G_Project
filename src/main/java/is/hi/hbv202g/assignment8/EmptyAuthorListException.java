package is.hi.hbv202g.assignment8;

/**
 * Excpetion thrown when method expects an author list but finds it empty
 */
public class EmptyAuthorListException extends Exception{
    

    /**
     * Constructor for EmptyAuthorListException
     * @param message the message explaining cause of the exception
     */
    public EmptyAuthorListException(String message){
        super(message);
    }

}
