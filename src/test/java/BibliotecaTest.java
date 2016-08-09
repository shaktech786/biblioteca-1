import org.junit.Test;
import java.io.PrintStream;
import static org.mockito.Mockito.*;

public class BibliotecaTest {

    @Test
    public void shouldDisplayWelcomeMessageWhenStarted() {
        PrintStream printStream = mock(PrintStream.class);
        Biblioteca biblioteca = new Biblioteca(printStream);

        biblioteca.start();

        verify(printStream).println(startsWith("Welcome!"));

    }
}