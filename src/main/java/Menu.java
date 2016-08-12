import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class Menu {

    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private Biblioteca biblioteca;
    private List<Option> optionList;

    public Menu(PrintStream printStream, BufferedReader bufferedReader, List<Option> optionList) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.biblioteca = biblioteca;
        this.optionList = optionList;
    }

    private void displayOptionList() {
        for (int i = 0; i < optionList.size(); i++) {
            printStream.println((i+1)+". "+optionList.get(i).optionName());
        }
    }

    private int getInput() throws IOException {
        String input = bufferedReader.readLine();
        while (!validInput(input)) {
            printStream.println("Select a valid option!");
            input = bufferedReader.readLine();
        }
        return Integer.parseInt(input)-1;
    }

    public void start() throws IOException {
        printStream.println("Welcome to Biblioteca!");
        displayOptionList();
        int optionIndex;


        do {
            optionIndex = getInput();
            Option option = optionList.get(optionIndex);
            option.run();
        }
        while (optionIndex != optionList.size()-1);
    }

    private boolean validInput(String input) throws IOException {
        int option = Integer.parseInt(input);
        return (option > 0 && option <= optionList.size());
    }

}
