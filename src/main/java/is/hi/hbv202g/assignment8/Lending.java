package is.hi.hbv202g.assignment8;
import java.time.LocalDate;

public class Lending{
    private LocalDate dueDate;
    private Borrowable book;
    private User user;

    public Lending(Borrowable book, User user) {
        this.book = book;
        this.user = user;
        this.dueDate = LocalDate.now().plusDays(30);
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Borrowable getBook() {
        return this.book;
    }

    public void setBook(Borrowable book) {
        this.book = book;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
