import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class QuitTest {

    @Test
    public void shouldSayGoodbyeWhenRun() throws Exception {
        PrintStream printStream = mock(PrintStream.class);
        Quit quit = new Quit(printStream);
        quit.run();
        verify(printStream).println("Goodbye!");

    }
}