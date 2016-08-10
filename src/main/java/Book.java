import java.io.PrintStream;

public class Book {

    private final PrintStream printStream;
    private final String title;
    private final String author;
    private final String yearPublished;

    public Book(String title, String author, String yearPublished, PrintStream printStream) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.printStream = printStream;
    }

    public void displayDetailsInColumns() {
        printStream.printf("%30s %-30s %-30s \n", title, author, yearPublished);
    }
}
