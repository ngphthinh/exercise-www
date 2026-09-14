package iuh.fit.se.bai4.dao;

import iuh.fit.se.bai4.model.Book;
import iuh.fit.se.bai4.util.DBUtil;
import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private final DBUtil util;

    public BookDAO(DataSource dataSource) {
        util = new DBUtil(dataSource);
    }


    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection conn = util.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            return getBooksFromRecord(books, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Book getBookById(String id) {
        String sql = "SELECT * FROM books WHERE book_id = ?";
        try (Connection conn = util.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                return Book.builder()
                        .bookId(rs.getString("book_id"))
                        .title(rs.getString("title"))
                        .author(rs.getString("author"))
                        .price(rs.getDouble("price"))
                        .quantity(rs.getInt("quantity"))
                        .image(rs.getString("image"))
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Book> searchBooks(String keyword) {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE LOWER(title) LIKE LOWER(?)";
        try (Connection conn = util.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            String searchPattern = "%" + keyword + "%";
            stmt.setString(1, searchPattern);
            ResultSet rs = stmt.executeQuery();
            return getBooksFromRecord(books, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Book> getBooksFromRecord(List<Book> books, ResultSet rs) throws SQLException {
        while (rs.next()) {
            Book book = new Book();
            book.setBookId(rs.getString("book_id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setPrice(rs.getDouble("price"));
            book.setQuantity(rs.getInt("quantity"));
            book.setImage(rs.getString("image"));
            books.add(book);
        }
        return books;
    }
}
