package is.hi.hbv202g.assignment8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main( String[] args )
    {
        LibrarySystem myLibrarySystem = new LibrarySystem();

        //Búa til student
        myLibrarySystem.addStudentUser("Emma", true);


        //Búa til facultymembers
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

        Scanner scan = new Scanner(System.in);
    

        System.out.println("Góðan daginn, velkominn á bókasafnið. Hvað heitir þú?");
        String name = scan.nextLine();

        User currentUser = myLibrarySystem.findUserByName(name);

        while(true){
            if(currentUser==null){
                System.out.println("Þessi notandi er ekki til, má bjóða þér að búa til notanda?");
                String svar = scan.nextLine();
                if((svar.toLowerCase()).equals("já")){
                    System.out.println("Hvað heitir þú?");
                    String newUsername = scan.nextLine();
                    myLibrarySystem.addStudentUser(newUsername, true);
                    currentUser = myLibrarySystem.findUserByName(newUsername);
                    break;
                    
                }
                else{
                    System.out.println("Ekkert mál velkomin/nn aftur!");
                    break;
                    
                }
            }
        }

        while (true) { 
            if(currentUser==null) break;
            //Tjékka ef user er til ef ekki bjóða að búa til 
            System.out.println("1. Finna bók eftir titill");
            System.out.println("2. Fá lánaða bók");
            System.out.println("3. Skila bók");
            System.out.println("4. Borga sekt");
            //Heldur áfram þanngað til stop
            
            int action = scan.nextInt();

            switch (action) {
                case 1:
                    
                    break;

                case 2:
                    
                    break;

                case 3:
                    
                    break;
                default:
                    throw new AssertionError();
            }
            
        }


    }
}
