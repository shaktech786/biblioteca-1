import java.io.PrintStream;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        PrintStream printStream = System.out;
        books.add(new Book("Title 1", "Author 1", "2000", printStream));
        books.add(new Book("Title 2", "Author 2", "2001", printStream));
        new Biblioteca(books, printStream).start();
    }
}