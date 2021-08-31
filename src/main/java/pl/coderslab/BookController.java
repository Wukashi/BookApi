package pl.coderslab;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    MockBookService mockBookService;

    public BookController() {
        this.mockBookService = new MockBookService();
    }

    @GetMapping
    @ResponseBody
    public List<Book> getList()
    {
        return mockBookService.getList();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Book showBook(@PathVariable("id") Long id)
    {
        return mockBookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteBook(@PathVariable("id") Long id)
    {
        mockBookService.deleteBook(id);
    }

    @PostMapping
    public void addBook(@RequestBody Book book){
        mockBookService.addBook(book);
    }

    @PutMapping
    public void editBook(@RequestBody Book book){
        mockBookService.editBook(book);
    }
}