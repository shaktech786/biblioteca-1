public class Quit implements Option {
    @Override
    public void run() {
        System.out.println("Goodbye!");
    }

    @Override
    public String optionName() {
        return "Quit";
    }
}
