import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {

    @Test
    public void shouldDisplayDetailsInColumns() {
        String title = "Book Title 1";
        String author = "Author 1";
        String yearPublished = "Year 1";
        PrintStream printStream = mock(PrintStream.class);
        Book book = new Book(title, author, yearPublished, printStream);

        book.displayDetailsInColumns();

        verify(printStream).printf("%-30s %-30s %-30s \n", title, author, yearPublished);
    }

}