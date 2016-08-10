import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Menu {

    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private Biblioteca biblioteca;

    public Menu(PrintStream printStream, BufferedReader bufferedReader, Biblioteca biblioteca) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.biblioteca = biblioteca;
    }

    public void displayOptionList() {
        printStream.println("1. List books");
    }

    public String getInput() throws IOException {
        return bufferedReader.readLine();
    }

    public void start() throws IOException {
        biblioteca.greet();
        displayOptionList();
        checkInput();
    }

    public void checkInput() throws IOException {
        validateInput();
        biblioteca.listBooks();
    }

    private void validateInput() throws IOException {
        String input = getInput();
        while (!input.equals("1")) {
            printStream.println("Select a valid option!");
            input = getInput();
        }
    }

    public void quit() {
    }
}
