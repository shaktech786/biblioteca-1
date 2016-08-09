import java.io.PrintStream;

public class Biblioteca {

    private final PrintStream printStream;

    public Biblioteca(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void start() {
        this.printStream.println("Welcome!");
    }

}
