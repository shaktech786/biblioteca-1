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

    private String getInput() throws IOException {
        String input = bufferedReader.readLine();
        while (!validInput(input)) {
            printStream.println("Select a valid option!");
            input = bufferedReader.readLine();
        }
        return input;
    }

    public void start() throws IOException {
        biblioteca.greet();
        displayOptionList();
        String input = actionOnInput();
        while (!input.equals("q")) {
            input = actionOnInput();
        }
    }

    public String actionOnInput() throws IOException {
        String input = getInput();

        // How to do this in loop since options should be able to be chosen
        // again and again until they want to quit
        switch (input) {
            case "1":
                biblioteca.listBooks();
                break;
            case "q":
                quit();
                break;
            default:
                break;
        }
        return input;
    }

    private boolean validInput(String input) throws IOException {
        return (input.equals("1")||input.equals("q"));
    }

    public void quit() {
        printStream.println("Goodbye!");
    }
}
