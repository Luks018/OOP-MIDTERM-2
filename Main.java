import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a new bookstore
        Bookstore bookstore = new Bookstore();

        // Add authors to the bookstore
        Author author1 = new Author("J.K. Rowling", "British");
        Author author2 = new Author("Nikoloz Baratashvili", "Georgian");
        Author author3 = new Author("Ilia Chavchavadze", "Georgian");
        Author author4 = new Author("Akaki Tsereteli", "Georgian");
        Author author5 = new Author("Shota Rustaveli", "Georgian");

        bookstore.addAuthor(author1);
        bookstore.addAuthor(author2);
        bookstore.addAuthor(author3);
        bookstore.addAuthor(author4);
        bookstore.addAuthor(author5);

        // Check if authors were added correctly
        assert bookstore.getAuthors().size() == 5 : "Test Failed: Authors not added correctly";

        // Print the bookstore state
        System.out.println("Bookstore before saving state: " + bookstore);

        // Save the state to the file
        bookstore.saveState();

        // Remove authors to test restore functionality
        bookstore.removeAuthor(author1);
        bookstore.removeAuthorByName("Nikoloz Baratashvili");

        // Check if authors were removed correctly
        assert bookstore.getAuthors().size() == 3 : "Test Failed: Authors not removed correctly";

        // Print the bookstore state after removal
        System.out.println("Bookstore after removing authors: " + bookstore);

        // Restore the state from the file
        bookstore.restoreState();

        // Check if the state was restored correctly
        assert bookstore.getAuthors().size() == 5 : "Test Failed: State not restored correctly";

        // Print the bookstore state after restoring
        System.out.println("Bookstore after restoring state: " + bookstore);

        // Verify the contents of the bookstore
        List<Author> authors = bookstore.getAuthors();
        assert authors.get(0).getName().equals("J.K. Rowling") : "Test Failed: Incorrect author in list";
        assert authors.get(1).getName().equals("Nikoloz Baratashvili") : "Test Failed: Incorrect author in list";
        assert authors.get(2).getName().equals("Ilia Chavchavadze") : "Test Failed: Incorrect author in list";
        assert authors.get(3).getName().equals("Akaki Tsereteli") : "Test Failed: Incorrect author in list";
        assert authors.get(4).getName().equals("Shota Rustaveli") : "Test Failed: Incorrect author in list";

        System.out.println("All tests passed.");
    }
}
