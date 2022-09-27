package pocket;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookActions {
    List<Book> books = new ArrayList<Book>();

    @PostConstruct
    public void init() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ignored) {
        }
    }

    public PreparedStatement getConnection(String insertion) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5434/postgres", "postgres", "root");
        PreparedStatement statement = connection.prepareStatement(insertion);
        return statement;
    }
    public List<Book> getBooks() throws SQLException {
        PreparedStatement preparedStatement = getConnection("select * from books");
        List<Book> books = new ArrayList<Book>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Book book = new Book();
            book.setName(resultSet.getString("name"));
            book.setPageCount(resultSet.getInt("pageCount"));
            book.setId(resultSet.getLong("id"));
            books.add(book);
        }
        return books;

    }

    public void deleteBookById(Long id) throws SQLException {
        PreparedStatement statement = getConnection("delete from books where id =? ");
        statement.setLong(1,id);
        int deletedRows = statement.executeUpdate();
        System.out.println("done");
        }




    public Book createBook(Book book) throws SQLException {
        List<Book> books = getBooks();
        PreparedStatement statement = getConnection("insert into books values(?,?,?)");
        statement.setString(1, book.getName());
        statement.setInt(2, book.getPageCount());
        statement.setLong(3, book.getId());
        books.add(book);
        int a = statement.executeUpdate();
        return book;
    }

    public List<Book> getBookById(Long id) throws SQLException {
        PreparedStatement statement = getConnection("select * from books where id=?");
        List<Book> books = new ArrayList<Book>();
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Book book = new Book();
            book.setId(resultSet.getLong("id"));
            book.setPageCount(resultSet.getInt("pageCount"));
            book.setName(resultSet.getString("name"));
            books.add(book);

        }
        return books;
    }


}
