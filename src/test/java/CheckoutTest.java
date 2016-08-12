import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutTest {
    private Biblioteca biblioteca;
    private Checkout checkout;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        biblioteca = mock(Biblioteca.class);
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        checkout = new Checkout(biblioteca, printStream, bufferedReader);
    }

    @Test
    public void shouldPromptUserForTitleWhenCheckingOut() throws IOException {
        checkout.run();
        verify(printStream).println("Which book would you like to checkout?");
        verify(bufferedReader).readLine();
    }

    @Test
    public void shouldTellBibliotecaToCheckoutBook() throws Exception {
        when(bufferedReader.readLine()).thenReturn("book title");
        checkout.run();
        verify(biblioteca).checkout("book title");
    }
}