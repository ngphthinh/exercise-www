package iuh.fit.se.demotrgh.service;

import iuh.fit.se.demotrgh.model.Book;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BookService {
    private static final List<Book> books;

    static {
        books = new ArrayList<>(List.of(
                Book.builder()
                        .id("S1")
                        .title("WWW")
                        .price(1000)
                        .build(),
                Book.builder()
                        .id("S2")
                        .title("BOOK2")
                        .price(1000)
                        .build(),
                Book.builder()
                        .id("S3")
                        .title("BOOK3")
                        .price(1000)
                        .build()
        ));
    }

    public List<Book> getAllBook() {
        return books;
    }

    public Book findById(String id) {
        return books.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    public void createBook(Book book) {
        books.add(book);
    }

    public void delete(String id) {
        books.removeIf(e -> e.getId().equals(id));
    }

    public void update(String id, Book newBook) {
        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).getId().equals(id)) {
                books.set(i, newBook);
                break;
            }
        }
    }

    public List<Book> search(String keyword) {
        return books.stream().filter(e -> e.getTitle().contains(keyword)).toList();
    }
}
