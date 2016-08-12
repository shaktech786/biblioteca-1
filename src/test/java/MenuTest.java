import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.TreeMap;

import static org.mockito.Mockito.*;

public class MenuTest {
    private PrintStream printStream;
    private Menu menu;
    private BufferedReader bufferedReader;
    private TreeMap<String, Option> optionList;
    private ListBooks listBooksOption;
    private Quit quitOption;
    private Checkout checkoutOption;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        optionList = new TreeMap<>();

        listBooksOption = mock(ListBooks.class);
        checkoutOption = mock(Checkout.class);
        quitOption = mock(Quit.class);
        optionList.put(Menu.LIST_BOOKS_SELECTION, listBooksOption);
        optionList.put(Menu.CHECKOUT_SELECTION, checkoutOption);
        optionList.put(Menu.QUIT_SELECTION, quitOption);
        menu = new Menu(printStream, bufferedReader, optionList);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenStarted() throws IOException {
        when(bufferedReader.readLine()).thenReturn(Menu.QUIT_SELECTION);
        menu.start();
        verify(printStream).println(startsWith("Welcome to Biblioteca!"));
    }

    @Test
    public void shouldDisplayAListOfOptionsWhenStarted() throws IOException {
        when(bufferedReader.readLine()).thenReturn(Menu.QUIT_SELECTION);
        when(listBooksOption.optionName()).thenReturn("option name");
        menu.start();
        verify(printStream).println(contains("option name"));
    }
    @Test
    public void shouldListBooksWhen1IsInput() throws IOException {
        when(bufferedReader.readLine()).thenReturn(Menu.LIST_BOOKS_SELECTION, Menu.QUIT_SELECTION);
        menu.start();
        verify(listBooksOption).run();
    }

    @Test
    public void shouldAskForAnotherInputIfInvalidInput() throws Exception {
        when(bufferedReader.readLine()).thenReturn("$", Menu.QUIT_SELECTION);
        menu.start();
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldAskForAnotherInputIfValidInput() throws IOException {
        when(bufferedReader.readLine()).thenReturn(Menu.LIST_BOOKS_SELECTION, Menu.LIST_BOOKS_SELECTION, Menu.QUIT_SELECTION);
        menu.start();
        verify(listBooksOption, times(2)).run();
    }

    @Test
    public void shouldQuitWhenLastOptionIsSelected() throws IOException {
        when(bufferedReader.readLine()).thenReturn(Menu.QUIT_SELECTION);
        menu.start();
        verify(quitOption).run();
    }

    @Test
    public void shouldCallCheckoutOptionWhenCheckoutIsSelected() throws Exception {
        when(bufferedReader.readLine()).thenReturn(Menu.CHECKOUT_SELECTION, Menu.QUIT_SELECTION);
        menu.start();
        verify(checkoutOption).run();
    }
}