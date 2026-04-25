package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private List<Borrowable> books;
    private List<Lending> lendings;
    private List<User> users;

    public LibrarySystem(){
        this.books=new ArrayList<>();
        this.lendings=new ArrayList<>();
        this.users=new ArrayList<>();

    }

    public List<Borrowable> getBookList(){
        return this.books;
    }

    public List<Lending> getLendings(){
        return this.lendings;
    }

    public void addBookWithTitleAndNameOfSingleAuthor(String title, String authorName){

        Book book=new Book(title, authorName);
        this.books.add(book);

        
    }

    public void addBookWithTitleAndAuthorList(String title, List<Author> authors) throws EmptyAuthorListException{
        if(authors==null ||authors.isEmpty()){
            throw new EmptyAuthorListException("A list of author names is required");
        }
        Book book=new Book(title, authors);
        this.books.add(book);

    }

    public void addStudentUser(String name, boolean feePaid){
        Student student=new Student(name, feePaid);
        this.users.add(student);

    }

    public void addFacultyMemberUser(String name, String department){
        FacultyMember member = new FacultyMember(name, department);
        this.users.add(member);

        
    }

    public Borrowable findBorrowableByTitle(String title){
        for (Borrowable book : books) {
            if(book.getTitle().equalsIgnoreCase(title))
                return book;
        }
        return null;
    }

    public User findUserByName(String name){
        for (User user : users) {
            if(user.getName().equalsIgnoreCase(name))
                return user;
            
        }
        return null;
    }

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
