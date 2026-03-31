package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private List<Book> books;
    private List<Lending> lendings;
    private List<User> users;

    public LibrarySystem(){
        this.books=new ArrayList<>();
        this.lendings=new ArrayList<>();
        this.users=new ArrayList<>();

    }

    public void addBookWithTitleAndNameOfSingleAuthor(String title, String authorName)throws EmptyAuthorListException{
        if(authorName==null){
            throw new EmptyAuthorListException("Authors name is required");
        }

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

    public Book findBookByTitle(String title){
        return null;
    }

    public User findUserByName(String name){
        return null;
        
    }

    public void borrowBook(User user, Book book) throws UserOrBookDoesNotExistException{
        if(book==null || user ==null){
            throw new UserOrBookDoesNotExistException("User or book cannot be empty");
        }
         

    }

    public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate) throws UserOrBookDoesNotExistException{
        if(book==null || facultyMember ==null){
            throw new UserOrBookDoesNotExistException("User or book cannot be empty");
        }

    }

    public void returnBook(User user, Book book) throws UserOrBookDoesNotExistException{
        if(book==null || user ==null){
            throw new UserOrBookDoesNotExistException("User or book cannot be empty");
        }
        
    }


}
