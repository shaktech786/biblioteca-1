import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Checkout implements Option{
    private final Biblioteca biblioteca;
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;

    public Checkout(Biblioteca biblioteca, PrintStream printStream, BufferedReader bufferedReader) {

        this.biblioteca = biblioteca;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run() {
        printStream.println("Which book would you like to checkout?");
        String title = readLine();
        biblioteca.checkout(title);
    }

    private String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String optionName() {
        return "Checkout book";
    }
}
