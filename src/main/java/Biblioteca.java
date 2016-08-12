import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Book> availableBooks;
    private List<Book> checkedOutBooks;

    public Biblioteca(ArrayList<Book> availableBooks) {
        this.availableBooks = availableBooks;
        checkedOutBooks = new ArrayList<>(); //should be injected eventually
    }

    public void listBooks() {
        for (Book book : availableBooks) {
            book.displayDetailsInColumns();
        }
    }

    public void checkout(String bookTitle) {
        for (Book book : availableBooks) {
            if (book.titleIs(bookTitle)) {
                move(book, availableBooks, checkedOutBooks);
                break;
            }
        }
    }

    private void move(Book book, List<Book> removeFrom, List<Book> addTo) {
        removeFrom.remove(book);
        addTo.add(book);
    }
}