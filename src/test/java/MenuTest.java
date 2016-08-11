import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.*;

public class MenuTest {
        PrintStream printStream;
        Menu menu;
        Biblioteca biblioteca;
        BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        biblioteca = mock(Biblioteca.class);
        menu = new Menu(printStream, bufferedReader, biblioteca);
    }

    @Test
    public void shouldDisplayAListOfOptionsWhenStarted() {
        menu.displayOptionList();
        verify(printStream).println("1. List books");
    }

    @Test
    public void shouldListBooksWhen1IsInput() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1", "q");
        menu.start();
        verify(biblioteca).listBooks();
    }

    @Test
    public void shouldAskForAnotherInputIfInvalidInput() throws Exception {
        when(bufferedReader.readLine()).thenReturn("0", "1", "q");
        menu.start();
        verify(printStream).println("Select a valid option!");
        verify(biblioteca).listBooks();
    }

    @Test
    public void shouldAskForAnotherInputIfValidInput() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1","1","q");
        menu.start();
        verify(biblioteca, times(2)).listBooks();
    }

    @Test
    public void shouldQuitWhenQIsPressed() throws IOException {
        when(bufferedReader.readLine()).thenReturn("q");
        menu.start();
        verify(printStream).println("Goodbye!");
    }
}