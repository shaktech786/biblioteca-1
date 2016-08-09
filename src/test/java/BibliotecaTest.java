import org.junit.Before;
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
        biblioteca.start();
        verify(printStream).println(startsWith("Welcome!"));
    }

    @Test
    public void shouldDisplayListOfBooksWithAuthorAndYearAfterWelcomeMessage() {
        biblioteca.start();
        verify(printStream).println(contains("Welcome!"));
        verify(book1).displayDetailsInColumns();
        verify(book2).displayDetailsInColumns();
    }
}