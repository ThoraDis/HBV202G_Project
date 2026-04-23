package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main( String[] args )
    {
        LibrarySystem myLibrarySystem = new LibrarySystem();

        //Búa til student
        Student emmaStudent = new Student("Emma", true);
        myLibrarySystem.addStudentUser("Emma", true);


        //Búa til facultymembers
        FacultyMember facultyMember = new FacultyMember("Kalli", "Vísindi");
        myLibrarySystem.addFacultyMemberUser("Kalli", "Vísindi");


        Author authorListOne= new Author("höfundurthrju");
        Author authorListTvo= new Author("höfundurfjögur");

        List<Author> authors = new ArrayList<>();
        authors.add(authorListOne);
        authors.add(authorListTvo);



        //Búa til bækur
        myLibrarySystem.addBookWithTitleAndNameOfSingleAuthor("Bók 1", "höfundureitt");
        myLibrarySystem.addBookWithTitleAndNameOfSingleAuthor("Bók 2", "höfundureitt");
        myLibrarySystem.addBookWithTitleAndNameOfSingleAuthor("Bók 3", "höfundurtvo");

        try {

            myLibrarySystem.addBookWithTitleAndAuthorList("Bók 4", authors);

        } catch (EmptyAuthorListException e) {
            System.out.println("Höfundarlisti er tóm " + e.getMessage());
        }

        //Bókaset
        Book bookfive = new Book("Bók 5", "höfundurfimm");
        Book booksix = new Book("Bók 6", "höfundurfimm");

        myLibrarySystem.addBookWithTitleAndNameOfSingleAuthor("Bók 5", "höfundurfimm");
        myLibrarySystem.addBookWithTitleAndNameOfSingleAuthor("Bók 6", "höfundurfimm");

        BookSet bokaset = new BookSet("Dinosaur series");
        bokaset.add(bookfive);
        bokaset.add(booksix);


        Scanner scan = new Scanner(System.in);
    
        System.out.println("Good day, welcome to the library. What is your name?:");
        String name = scan.nextLine();

        User currentUser = myLibrarySystem.findUserByName(name);

        while(true){
            if(currentUser==null){
                System.out.println("This user does not exist, create user?");
                String svar = scan.nextLine();
                if((svar.toLowerCase()).equals("yes")){
                    myLibrarySystem.addStudentUser(name, true);
                    currentUser = myLibrarySystem.findUserByName(name);
                    break;
                    
                }
                else{
                    System.out.println("No problem, welcome back!");
                    break;
                    
                }
            }
            
            break;
        }

        while (true) { 
            if(currentUser==null) break;

            //Tjékka ef user er til ef ekki bjóða að búa til 
            System.out.println("Hello " + currentUser.getName() + ", input a number to use the library.");

            System.out.println("1. Borrow a book or bookset");
            System.out.println("2. Return a book or bookset");
            System.out.println("3. See borrowed books/booksets");
            System.out.println("4. Pay a fine");
            System.out.println("5. Extend fine");
            System.out.println("0. To quit");

            //Heldur áfram þanngað til stop
            
            int action = scan.nextInt();
            scan.nextLine();

            switch (action) {
                case 1:
                    System.out.println("Enter book/bookset title");
                    String borrow = scan.nextLine();
                    Borrowable toBorrow = myLibrarySystem.findBookByTitle(borrow);
                    try{
                        myLibrarySystem.borrowBook(currentUser, toBorrow);
                    } catch (UserOrBookDoesNotExistException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 2:
                    if(currentUser instanceof Student){
                        System.out.println("Enter book/bookset title");
                        String returned = scan.nextLine();
                        Borrowable borrowed = myLibrarySystem.findBookByTitle(returned);

                        try{
                            myLibrarySystem.returnBook((Student) currentUser, borrowed);
                        } catch (UserOrBookDoesNotExistException e) {
                            System.out.println(e.getMessage());
                        }

                    } else{
                        System.out.println("Only a student can return book");
                        
                    }
                    break;

                case 3:

                    Boolean noLendings = true;
                    for (Lending lending : myLibrarySystem.getLendings()) {
                        if(lending.getUser().equals(currentUser)){
                            System.out.println(lending.getUser().getName() + " borrowed " + lending.getBook().getTitle()+ "is due" + lending.getDueDate());
                            noLendings=false;
                        }
                    }   

                    if(!noLendings){
                        System.out.println("No borrowed books");
                    }
                    break;
                
                case 4:
                    if(currentUser instanceof Student){
                        Student student = (Student) currentUser;

                        if (student.isFeePaid()) {
                            System.out.println("No unpaid fines");
                            
                        } else{
                            student.setFeePaid(true);
                            System.out.println("Fine paid");
                        }

                    } else{
                        System.out.println("Only a student can pay fine");
                        
                    }
                    break;

                case 5:
                    if(currentUser instanceof FacultyMember){
                        FacultyMember currentFacultyMember = (FacultyMember) currentUser;
                        System.out.println("Enter book/bookset title");
                        String extend = scan.nextLine();
                        Borrowable toExtend = myLibrarySystem.findBookByTitle(extend);
                    try{
                        myLibrarySystem.extendLending(currentFacultyMember, toExtend, LocalDate.now().plusDays(7));
                    } catch (UserOrBookDoesNotExistException e) {
                        System.out.println(e);
                        
                    }

                }
                else{
                    System.out.println("Only faculty members can extend lendings");
                }

                    break;

                case 0:
                    System.err.println("Goodbye");
                    scan.close();
                    return;
                default:
                    System.out.println("Unknown command");
            }
            
        }


    }
}
