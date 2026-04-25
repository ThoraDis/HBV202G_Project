# HBV202G: Final project

This project is a library system that has a collection of book titles and collections of books. To borrow a book/bookset a user must be logged inn and an the title must be available. When a title is borrowed it creates a lending connected to the user and return date, if the title is a bookset or in a bookset then all the books are borrowed. The return date can br extended must be done by a faculty member. When the title is returned by the user it becomes available and if it was turned inn after the due date a student will get a fee that can be paid in the library.

## Installation
This project is a Maven project, i.e. it uses the standard Maven project structure that your IDE should understand  when you `git clone` it. 

## Running

Maven:

- `mvn compile` compiles all implementation classes.
- `mvn exec:java` executes the `main` method of the implementation
- `mvn test` runs test cases
- `mvn package` package the project into a JAR file that is stored in the target folder
- `mvn site` creates a project website

## Design pattern

This project uses the composite pattern to create a bookset that contains more than one book. This makes it so if one book in the set is borrowed then all books are borrowed with lendings.
<Borrowable> is the common interface for both the atomic object <Book> and the container object <BookSet> allows us to treat them uniformly.

## License

This project is licensed under the MIT license see the [License file](LICENSE)

## UML class diagram

[UML class diagram](src/site/markdown/uml.md)