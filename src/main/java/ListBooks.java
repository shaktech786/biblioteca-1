public class ListBooks implements Option {
    private Biblioteca biblioteca;

    public ListBooks(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override



    public void run() {
        biblioteca.listBooks();
    }

    @Override
    public String optionName() {
        return "List books";
    }
}
