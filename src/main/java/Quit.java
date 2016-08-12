import java.io.PrintStream;

public class Quit implements Option {
    private PrintStream printStream;

    public Quit(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void run() {
        printStream.println("Goodbye!");
    }

    @Override
    public String optionName() {
        return "Quit";
    }
}
