import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Book> books = new ArrayList<>();
        PrintStream printStream = System.out;
        books.add(new Book("Title 1", "Author 1", "2000", printStream));
        books.add(new Book("Title 2", "Author 2", "2001", printStream));

        Biblioteca biblioteca = new Biblioteca(books, printStream);
        List<Option> optionList = new ArrayList<>();
        optionList.add(new ListBooks(biblioteca));
        optionList.add(new Quit());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Menu menu = new Menu(printStream, bufferedReader, optionList);
        menu.start();
    }
}