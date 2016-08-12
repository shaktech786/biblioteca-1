import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.*;

public class MenuTest {
        PrintStream printStream;
        Menu menu;
        Biblioteca biblioteca;
        BufferedReader bufferedReader;
        List<Option> optionList;
        ListBooks listBooksOption;
        Quit quitOption;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        biblioteca = mock(Biblioteca.class);
        optionList = new ArrayList<>();

        listBooksOption = mock(ListBooks.class);
        optionList.add(listBooksOption);
        quitOption = mock(Quit.class);
        optionList.add(quitOption);
        menu = new Menu(printStream, bufferedReader, optionList);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenStarted() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");
        menu.start();
        verify(printStream).println(startsWith("Welcome to Biblioteca!"));
    }

    @Test
    public void shouldDisplayAListOfOptionsWhenStarted() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");
        when(listBooksOption.optionName()).thenReturn("option name");
        menu.start();
        verify(printStream).println(contains("option name"));
    }
    @Test
    public void shouldListBooksWhen1IsInput() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1", "2");
        menu.start();
        verify(listBooksOption).run();
    }

    @Test
    public void shouldAskForAnotherInputIfInvalidInput() throws Exception {
        when(bufferedReader.readLine()).thenReturn("0", "2");
        menu.start();
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldAskForAnotherInputIfValidInput() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1","1","2");
        menu.start();
        verify(listBooksOption, times(2)).run();
    }

    @Test
    public void shouldQuitWhenLastOptionIsSelected() throws IOException {
        when(bufferedReader.readLine()).thenReturn(Integer.toString(optionList.size()));
        menu.start();
        verify(quitOption).run();
    }
}