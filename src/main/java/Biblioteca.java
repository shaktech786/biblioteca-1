import java.io.PrintStream;

public class Biblioteca {

    private final PrintStream printStream;

    public Biblioteca(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void start() {
        printStream.println("Welcome!");
        listBooks();
    }

    private void listBooks() {
        printStream.println("Book Title 1");
        printStream.println("Book Title 2");
    }

}
