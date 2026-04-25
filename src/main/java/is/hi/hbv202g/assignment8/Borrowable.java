package is.hi.hbv202g.assignment8;

import java.time.LocalDate;

public interface Borrowable{
    String getTitle();

    void borrowAll(User user,LibrarySystem library) throws UserOrBookDoesNotExistException;

    void extendAll(FacultyMember facultyMember, LocalDate newDueDate, LibrarySystem library) throws UserOrBookDoesNotExistException;

    void returnAll(Student student, LibrarySystem library) throws UserOrBookDoesNotExistException;

}