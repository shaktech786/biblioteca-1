import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {

    private String title;
    private String author;
    private String yearPublished;
    private PrintStream printStream;
    private Book book;

    @Before
    public void setUp() throws Exception {
        title = "Book Title 1";
        author = "Author 1";
        yearPublished = "Year 1";
        printStream = mock(PrintStream.class);
        book = new Book(title, author, yearPublished, printStream);
    }

    @Test
    public void shouldDisplayDetailsInColumns() {

        book.displayDetailsInColumns();

        verify(printStream).printf("%-30s %-30s %-30s \n", title, author, yearPublished);
    }

    @Test
    public void shouldReturnWhetherInputIsTitleOrNot() throws Exception {
        assertTrue(book.titleIs(title));
    }
}