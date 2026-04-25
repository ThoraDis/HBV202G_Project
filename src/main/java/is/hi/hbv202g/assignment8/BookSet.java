package is.hi.hbv202g.assignment8;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * A bookset with many books that can be borrowed or returned from the library
 */
public class BookSet implements Borrowable{
    private List<Borrowable> books = new ArrayList<Borrowable>();
    private String title;

    /**
     * Constructor for bookset
     * @param title the title of the bookset
     */
    public BookSet(String title) {
        this.title = title;
    }

    /**
     * Add one book to the bookset
     * @param book the book to add
     */
    public void add(Borrowable book) {
        books.add(book);
    }

    /**
     * Remove one book from the bookset
     * @param book the book to remove
     */
    public void remove(Borrowable book) {
        books.remove(book);
    }

    /**
     * Returns all books in the bookset
     * @return the list of books in the bookset
     */
    public List<Borrowable> getChildren() {
        return books;
    }

    @Override
    public void borrowAll(User user, LibrarySystem library) throws UserOrBookDoesNotExistException {

        for (Borrowable borrowable : books) {
            borrowable.borrowAll(user, library);

        }

    }

    @Override
    public void returnAll(Student student, LibrarySystem library) throws UserOrBookDoesNotExistException {

        for (Borrowable borrowable : books) {
            borrowable.returnAll(student, library);

        }

    }

    @Override
    public void extendAll(FacultyMember facultyMember, LocalDate newDueDate, LibrarySystem library) throws UserOrBookDoesNotExistException {

        for (Borrowable borrowable : books) {
            borrowable.extendAll(facultyMember, newDueDate, library);

        }

    }

    @Override
    public String getTitle(){
        return title;
    }

    @Override
    public void setTitle(String title){
        this.title=title;
    }


}