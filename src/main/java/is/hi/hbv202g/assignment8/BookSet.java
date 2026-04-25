package is.hi.hbv202g.assignment8;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookSet implements Borrowable{
    private List<Borrowable> books = new ArrayList<Borrowable>();
    private String title;

    public BookSet(String title) {
        this.title = title;
    }

    public void add(Borrowable book) {
        books.add(book);
    }

    public void remove(Borrowable book) {
        books.remove(book);
    }
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


}