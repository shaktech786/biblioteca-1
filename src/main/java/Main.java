import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Title 1", "Author 1", "2000", printStream));
        books.add(new Book("Title 2", "Author 2", "2001", printStream));

        Biblioteca biblioteca = new Biblioteca(books);
        TreeMap<String, Option> options = new TreeMap<>();
        options.put(Menu.LIST_BOOKS_SELECTION, new ListBooks(biblioteca));
        options.put(Menu.CHECKOUT_SELECTION, new Checkout(biblioteca, printStream, bufferedReader));
        options.put(Menu.QUIT_SELECTION, new Quit(printStream));
        Menu menu = new Menu(printStream, bufferedReader, options);
        menu.start();
    }
}