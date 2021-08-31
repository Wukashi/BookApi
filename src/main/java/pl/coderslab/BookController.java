package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getList()
    {
        return bookService.getList();
    }

    @GetMapping("/{id}")
    public Book showBook(@PathVariable("id") Long id)
    {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id)
    {
        bookService.deleteBook(id);
    }

    @PostMapping
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @PutMapping
    public void editBook(@RequestBody Book book){
        bookService.editBook(book);
    }
}