import java.io.PrintStream;
import java.util.ArrayList;

public class Biblioteca {

    private final ArrayList<Book> books;
    private final PrintStream printStream;

    public Biblioteca(ArrayList<Book> books, PrintStream printStream) {
        this.books = books;
        this.printStream = printStream;
    }

    public void greet() {
        printStream.println("Welcome to Biblioteca!");
    }

    public void listBooks() {
        for (Book book : books) {
            book.displayDetailsInColumns();
        }
    }

}