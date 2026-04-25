package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The library system
 */
public class LibrarySystem {
    private List<Borrowable> books;
    private List<Lending> lendings;
    private List<User> users;

    /**
     * Constructor for the library system
     */
    public LibrarySystem(){
        this.books=new ArrayList<>();
        this.lendings=new ArrayList<>();
        this.users=new ArrayList<>();

    }

    /**
     * Returns all books and booksets in the library
     * @return a list of borrowables
     */
    public List<Borrowable> getBookList(){
        return this.books;
    }

    /**
     * Retruns all lendings in the library system
     * @return a list of lendings
     */
    public List<Lending> getLendings(){
        return this.lendings;
    }

    /**
     * Add a book with title and a single author to the library system
     * @param title the title of the book
     * @param authorName the name of the author
     */
    public void addBookWithTitleAndNameOfSingleAuthor(String title, String authorName){

        Book book=new Book(title, authorName);
        this.books.add(book);

        
    }

    /**
     * Add a book with a title and a list of authors to the library system
     * @param title the title of the book
     * @param authors the list of authors
     * @throws EmptyAuthorListException if authors is empty
     */
    public void addBookWithTitleAndAuthorList(String title, List<Author> authors) throws EmptyAuthorListException{
        if(authors==null ||authors.isEmpty()){
            throw new EmptyAuthorListException("A list of author names is required");
        }
        Book book=new Book(title, authors);
        this.books.add(book);

    }

    /**
     * Adds a student user to the library system
     * @param name the name of the student
     * @param feePaid the boolean value of if they paid their fee
     */
    public void addStudentUser(String name, boolean feePaid){
        Student student=new Student(name, feePaid);
        this.users.add(student);

    }

    /**
     * Adds a facultyMember user to the library system
     * @param name the name of the facultyMember
     * @param department the department of the facultyMember
     */
    public void addFacultyMemberUser(String name, String department){
        FacultyMember member = new FacultyMember(name, department);
        this.users.add(member);

        
    }

    /**
     * Find a book or bookset by their title in the library system
     * @param title the title of the book or bookset
     * @return the borrowble with the title or null if not found
     */
    public Borrowable findBorrowableByTitle(String title){
        for (Borrowable book : books) {
            if(book.getTitle().equalsIgnoreCase(title))
                return book;
        }
        return null;
    }

    /**
     * Find user by name in the library system
     * @param name the name of the user
     * @return the user with the name but if not found return null
     */
    public User findUserByName(String name){
        for (User user : users) {
            if(user.getName().equalsIgnoreCase(name))
                return user;
            
        }
        return null;
    }

    /**
     * Borrow a book or bookset from the library system
     * @param user the user that wants to borrow
     * @param borrowable the book or bookset to borrpw
     * @throws UserOrBookDoesNotExistException if user or borrowable is empty
     */
    public void borrowBorrowable(User user, Borrowable borrowable) throws UserOrBookDoesNotExistException{
        if(borrowable==null || user ==null){
            throw new UserOrBookDoesNotExistException("User or book cannot be empty");
        }
         

        for (Lending lend : lendings) {
            if(lend.getBook().equals(borrowable)){
                System.out.println("Bók er nú þegar í láni, sorrý.");
                return;
            }
            
        }

        Lending lending = new Lending(borrowable, user);
        lendings.add(lending);

    }

    /**
     * Extends the lending of a book
     * @param facultyMember the facultyMember that can extend the lending
     * @param borrowable the book with a lending
     * @param newDueDate the new due date for lending
     * @throws UserOrBookDoesNotExistException if user or borrowable is empty
     */
    public void extendLending(FacultyMember facultyMember, Borrowable borrowable, LocalDate newDueDate) throws UserOrBookDoesNotExistException{
        if(borrowable==null || facultyMember ==null){
            throw new UserOrBookDoesNotExistException("User or book cannot be empty");
        }

        for (Lending lend : lendings) {
            if(lend.getBook().equals(borrowable) && lend.getUser().equals(facultyMember)){
                System.out.println("Lán er lengt til" + newDueDate.toString());
                lend.setDueDate(newDueDate);
                return;
            }
        }

        System.out.println("No such loan in system");

    }

    /**
     * Returns book or all books in a bookset
     * @param student the student retruning the book or bookset
     * @param borrowable the book or bookset to return 
     * @throws UserOrBookDoesNotExistException if user or borrowable is empty
     */
    public void returnBorrowable(Student student, Borrowable borrowable) throws UserOrBookDoesNotExistException{
        if(borrowable==null || student ==null){
            throw new UserOrBookDoesNotExistException("User or book cannot be empty");
        }

        Lending lendingNotanda = null;
        
        for (Lending lend : lendings) {
            if(lend.getBook().equals(borrowable) && lend.getUser().equals(student)){
                if(LocalDate.now().isAfter(lend.getDueDate())){
                    System.out.println("Book was returned late, fee applied");
                    student.setFeePaid(false);
                    lendingNotanda=lend;

                } else{
                    System.out.println("Loan paid");
                    lendingNotanda=lend;
                }
            }
        }

        if(lendingNotanda==null){
            System.out.println("This is title is available or wrong user");
        }

        lendings.remove(lendingNotanda);
    }


}
