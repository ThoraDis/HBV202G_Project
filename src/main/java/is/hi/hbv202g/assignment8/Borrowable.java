package is.hi.hbv202g.assignment8;

import java.time.LocalDate;

/**
 * A bookset or book that can be borrowed or returned from the library
 */
public interface Borrowable{
    /**
     * Return title of the borrowable
     * 
     * @return the title of the borrowable
     */
    String getTitle();

    /**
     * Set a new title for the borrowable
     * 
     * @param title the new title of the borrowable
     */
    void setTitle(String title);

    /**
     * Borrow all borrowables inside the collection for one user.
     * For a bookset this borrows all books and for a book only borrows that one book
     * 
     * @param user the user borrowing the borrowables
     * @param library the library system that manages all borrowables
     * @throws UserOrBookDoesNotExistException if the user does not exist in the library system
     */
    void borrowAll(User user,LibrarySystem library) throws UserOrBookDoesNotExistException;

    /**
     * Extend all borrowables inside the collection for one user.
     * For a bookset this extends all lendings for books in set and for a book only extends the lending for one book
     * 
     * @param facultyMember the facultyMember extending the lendings
     * @param newDueDate the new due date for lendings
     * @param library the library system that manages all borrowables
     * @throws UserOrBookDoesNotExistException if the facultyMember does not exist in the library system
     */
    void extendAll(FacultyMember facultyMember, LocalDate newDueDate, LibrarySystem library) throws UserOrBookDoesNotExistException;

    /**
     * Returns all borrowables inside the collection
     * For a bookset this returns all books and for a book only returns that one book
     * @param student the student returning the borrowables
     * @param library the library system that manages all borrowables
     * @throws UserOrBookDoesNotExistException if the student does not exist in the library system
     */
    void returnAll(Student student, LibrarySystem library) throws UserOrBookDoesNotExistException;

}