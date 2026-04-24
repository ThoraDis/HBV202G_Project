package is.hi.hbv202g.assignment8;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LibrarySystemTest {
    private LibrarySystem system;

    @BeforeEach
    void constructLibrarySystem() {
        LibrarySystem system = new LibrarySystem();
    }

    @Test
    public void testAddBookWithTitleAndNameOfSingleAuthor() {
        system.addBookWithTitleAndNameOfSingleAuthor("Book", "Author");

        Borrowable book = system.findBookByTitle("Book");
        assertNotNull(book);
    }

    @Test
    public void testAddBookWithTitleAndAuthorListThrowsException() {
        assertThrows(EmptyAuthorListException.class, () -> {
            system.addBookWithTitleAndAuthorList("Book", new ArrayList<>());
        });
    }

    @Test
    public void testAddStudentUser() {
        system.addStudentUser("Lilja", true);
        User user = system.findUserByName("Lilja");
        assertNotNull(user);
    }

    @Test
    public void testAddFacultyMemberUser() {
        system.addFacultyMemberUser("Elfa", "department");
        User user = system.findUserByName("Elfa");
        assertNotNull(user);
    }

    @Test
    public void testFindBookByTitle_found() {
        system.addBookWithTitleAndNameOfSingleAuthor("Book", "Author");

        Borrowable result = system.findBookByTitle("Book");

        assertNotNull(result);
        assertEquals("Book", result.getTitle());
    }

    @Test
    public void testFindBookByTitle_notFound() {
        Borrowable result = system.findBookByTitle("Unknown");

        assertNull(result);
    }

    @Test
    public void testFindUserByName_found() {
        system.addStudentUser("Lilja", true);

        User result = system.findUserByName("Lilja");

        assertNotNull(result);
        assertEquals("Lilja", result.getName());
    }

    @Test
    public void testFindUserByName_notFound() {
        User result = system.findUserByName("Lilja");

        assertNull(result);
    }
    
    @Test
    void testBorrowBook_addsLending() throws Exception {

        system.addBookWithTitleAndNameOfSingleAuthor("Book", "Author");
        system.addStudentUser("Lilja", true);

        Borrowable book = system.findBookByTitle("Book");
        User user = system.findUserByName("Lilja");

        system.borrowBook(user, book);

        assertEquals(1, system.getLendings().size());
    }
}

