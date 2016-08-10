import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private PrintStream printStream;
    private Book book1;
    private Book book2;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        ArrayList<Book> books = new ArrayList<>();
        book1 = mock(Book.class);
        book2 = mock(Book.class);
        books.add(book1);
        books.add(book2);
        biblioteca = new Biblioteca(books, printStream);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenStarted() {
        biblioteca.greet();
        verify(printStream).println(startsWith("Welcome to Biblioteca!"));
    }

    @Test
    @Ignore
    public void shouldDisplayListOfBooksWithAuthorAndYearAfterWelcomeMessage() {
        biblioteca.greet();
        verify(printStream).println(contains("Welcome to Biblioteca!"));
        verify(printStream).println(contains("Book 1"));
        verify(printStream).println(contains("Book 2"));
    }
}