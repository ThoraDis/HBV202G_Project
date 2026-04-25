package is.hi.hbv202g.assignment8;
import java.time.LocalDate;

/**
 * A lending for a book
 */
public class Lending{
    private LocalDate dueDate;
    private Borrowable book;
    private User user;

    /**
    * Constructor for lending
     * 
     * @param book the book that is in loan
     * @param user the user that borrowed the borrowable
     */
    public Lending(Borrowable book, User user) {
        this.book = book;
        this.user = user;
        this.dueDate = LocalDate.now().plusDays(30);
    }

    /**
     * Get the due date 
     * 
     * @return the due date for the lending
     */
    public LocalDate getDueDate() {
        return this.dueDate;
    }

    /**
    * Set a new due date
    * @param dueDate the new due date for lending
    */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Get the book for the lending
     * @return the book that is in loan
     */
    public Borrowable getBook() {
        return this.book;
    }

    /**
     * Set a new book for the lending
     * @param book the new book for the loan
     */
    public void setBook(Borrowable book) {
        this.book = book;
    }

    /**
     * Get the user for the lending
     * @return the user that borrowed the book
     */
    public User getUser() {
        return this.user;
    }

    /**
     * Set a new user for the lending
     * @param user the new user for the lending
     */
    public void setUser(User user) {
        this.user = user;
    }


}
