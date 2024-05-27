import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bookstore {
    private List<Author> authors;

    // Constructor
    public Bookstore() {
        this.authors = new ArrayList<>();
    }

    // Method to add an author
    public void addAuthor(Author author) {
        authors.add(author);
    }

    // Method to remove an author by object
    public void removeAuthor(Author author) {
        authors.remove(author);
    }

    // Method to remove an author by name
    public boolean removeAuthorByName(String name) {
        for (Author author : authors) {
            if (author.getName().equals(name)) {
                authors.remove(author);
                return true;
            }
        }
        return false;
    }

    // Method to save the state to a file
    public void saveState() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("state.csv"))) {
            for (Author author : authors) {
                writer.write(author.getName() + "," + author.getNationality());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to restore the state from a file
    public void restoreState() {
        authors.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("state.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    authors.add(new Author(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getters and Setters
    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Bookstore{" +
                "authors=" + authors +
                '}';
    }
}
