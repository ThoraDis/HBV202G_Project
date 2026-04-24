package is.hi.hbv202g.assignment8;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookSet implements Borrowable{
    private List<Borrowable> bookVolumes = new ArrayList<Borrowable>();
    private String title;

    public BookSet(String title) {
        this.title = title;
    }

    public void add(Borrowable book) {
        bookVolumes.add(book);
    }

    public void remove(Borrowable book) {
        bookVolumes.remove(book);
    }
    public List<Borrowable> getChildren() {
        return bookVolumes;
    }

    public void borrow(User user, LibrarySystem library) throws UserOrBookDoesNotExistException {

        for (Borrowable volume : bookVolumes) {
            volume.borrow(user, library);

        }

    }

    public void returnAll(Student user, LibrarySystem library) throws UserOrBookDoesNotExistException {

        for (Borrowable volume : bookVolumes) {
            volume.returnAll(user, library);

        }

    }

    public void extendAll(FacultyMember facultyMember, LocalDate newDueDate, LibrarySystem library) throws UserOrBookDoesNotExistException {

        for (Borrowable volume : bookVolumes) {
            volume.extendAll(facultyMember, newDueDate, library);

        }

    }

    @Override
    public String getTitle(){
        return title;
    }


}