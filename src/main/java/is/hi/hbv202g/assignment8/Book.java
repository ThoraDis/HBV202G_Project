package is.hi.hbv202g.assignment8;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Book implements Borrowable{

    private String title;
    private List<Author> authors;

    public Book(String title, String authorName){
        if(authorName==null){
            throw new Error("Authors name is required");
        }

        Author author = new Author(authorName);
        this.title=title;
        this.authors=new ArrayList<>();
        this.authors.add(author);
        
    }

    public Book(String title, List<Author> authors) throws EmptyAuthorListException{
        if(authors==null ||authors.isEmpty()){
            throw new EmptyAuthorListException("A list of author names is required");
        }
        this.title=title;
        this.authors=new ArrayList<>();
        this.authors=authors;

    }

    public List<Author> getAuthors(){
        return this.authors;
    }

    public void setAuthors(List<Author> authors) throws EmptyAuthorListException{
        if(authors==null ||authors.isEmpty()){
            throw new EmptyAuthorListException("A list of author names is required");
        }
        this.authors=authors;
    }

    public void addAuthor(Author author)throws EmptyAuthorListException{
        if(author == null){
            throw new EmptyAuthorListException("Author is required");
        }
        this.authors.add(author);
    }

    @Override
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    @Override
    public void borrowAll(User user, LibrarySystem library) throws UserOrBookDoesNotExistException{
        library.borrowBorrowable(user, this);

    }

    @Override
    public void returnAll(Student student, LibrarySystem library) throws UserOrBookDoesNotExistException{
    
        library.returnBorrowable(student, this);

    }

    @Override
    public void extendAll(FacultyMember facultyMember, LocalDate newDueDate, LibrarySystem library) throws UserOrBookDoesNotExistException{
        library.extendLending(facultyMember, this, newDueDate);
    }

}
