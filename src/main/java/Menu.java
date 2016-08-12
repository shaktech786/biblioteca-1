import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.TreeMap;

public class Menu {

    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private TreeMap<String, Option> options;
    public static final String LIST_BOOKS_SELECTION = "1";
    public static final String CHECKOUT_SELECTION = "2";
    public static final String QUIT_SELECTION = "q";

    public Menu(PrintStream printStream, BufferedReader bufferedReader, TreeMap<String, Option> options) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.options = options;
    }

    private void displayOptionList() {
        for (Map.Entry<String, Option> option : options.entrySet()) {
            printStream.println(option.getKey()+". "+ option.getValue().optionName());
        }
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
        printStream.println("Welcome to Biblioteca!");
        String optionIndex;

        do {
            displayOptionList();
            printStream.println("--------------------");
            optionIndex = getInput();
            Option option = options.get(optionIndex);
            option.run();

        }
        while (!optionIndex.equals(QUIT_SELECTION));
    }

    private boolean validInput(String input) throws IOException {
        return options.containsKey(input);
    }

}
