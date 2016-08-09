import org.junit.Before;
import org.junit.Test;
import java.io.PrintStream;
import static org.mockito.Mockito.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private PrintStream printStream;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        biblioteca = new Biblioteca(printStream);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenStarted() {
        biblioteca.start();
        verify(printStream).println(startsWith("Welcome!"));
    }

    @Test
    public void shouldDisplayListOfBooksAfterWelcomeMessage() {
        biblioteca.start();
        verify(printStream).println(contains("Welcome!"));
        verify(printStream).println(contains("Book Title 1"));
        verify(printStream).println(contains("Book Title 2"));
    }
}