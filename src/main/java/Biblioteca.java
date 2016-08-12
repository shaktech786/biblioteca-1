import java.io.PrintStream;
import java.util.ArrayList;

public class Biblioteca {

    private final ArrayList<Book> books;
    private final PrintStream printStream;

    public Biblioteca(ArrayList<Book> books, PrintStream printStream) {
        this.books = books;
        this.printStream = printStream;
    }

    public void listBooks() {
        for (Book book : books) {
            book.displayDetailsInColumns();
        }
    }

}