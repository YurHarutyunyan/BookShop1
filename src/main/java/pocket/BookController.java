package pocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/Book")
public class BookController {
  BookActions actions = new BookActions();
    @Autowired
            public BookController(BookActions actions){
        this.actions=actions;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET,produces ="application/json")
    public List<Book> getBooks()throws SQLException{
    return actions.getBooks();
    }
    @DeleteMapping(value = "/delete/{id}")
    public void deletePostById(@PathVariable  Long id)throws SQLException{
        actions.deleteBookById(id);
    }
    @PostMapping(value = "/create")
    public Book createBook(@RequestBody Book book)throws SQLException{
        return actions.createBook(book);
    }
    @RequestMapping (value = "/get/{id}",method = RequestMethod.GET,produces = "application/json")
    public List<Book> getBookById(@PathVariable Long id)throws SQLException{
        return actions.getBookById(id);
    }
}
