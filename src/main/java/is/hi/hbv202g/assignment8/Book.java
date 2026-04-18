package is.hi.hbv202g.assignment8;
import java.util.ArrayList;
import java.util.List;

public class Book {

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

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title=title;
    }


}
