import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksTest {

    @Test
    public void shouldTellBibliotecaToListBooks() throws Exception {
        Biblioteca biblioteca = mock(Biblioteca.class);
        ListBooks listBooks = new ListBooks(biblioteca);
        listBooks.run();
        verify(biblioteca).listBooks();

    }
}