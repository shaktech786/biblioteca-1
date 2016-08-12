import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private Book book1;
    private Book book2;
    private ArrayList<Book> books;

    @Before
    public void setUp() {
        books = new ArrayList<>();
        book1 = mock(Book.class);
        book2 = mock(Book.class);
        books.add(book1);
        books.add(book2);
        biblioteca = new Biblioteca(books);
    }

    @Test
    public void shouldDisplayListOfBooksWithAuthorAndYearAfterWelcomeMessage() {
        biblioteca.listBooks();
        verify(book1).displayDetailsInColumns();
        verify(book2).displayDetailsInColumns();
    }

    @Test
    public void shouldMoveBookOutOfAvailableBooksIntoCheckoutBooksWhenCheckingOut() throws Exception {
        when(book1.titleIs("book title")).thenReturn(true);
        biblioteca.checkout("book title");
        assertTrue(!books.contains(book1));
    }
}