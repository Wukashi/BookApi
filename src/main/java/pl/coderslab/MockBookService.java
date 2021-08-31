package pl.coderslab;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MockBookService implements BookService{
    private static Long nextId = 4L;
    private List<Book> list;

    public MockBookService() {
        this.list = new ArrayList<>();
        list.add(new Book(1L,"9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L,"9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L,"9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public List<Book> getList() {
        return list;
    }
    
    public Book getBookById(Long id)
    {
        for (Book b : getList()) {
            if (id.equals(b.getId())) {
                return b;
            }
        }
        return null;
    }
    
    public void deleteBook(Long id)
    {
        List<Book> books = getList();
        for (int i = 0; i < books.size(); i++) {
            if(id.equals(books.get(i).getId()))
            {
                books.remove(i);
                break;
            }
        }
    }

    public void editBook(Book book)
    {
        List<Book> books = getList();
        for (Book b : books) {
            if (book.getId() == b.getId()) {
                b.setIsbn(book.getIsbn());
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
                b.setPublisher(book.getPublisher());
                b.setType(book.getType());
                break;
            }
        }
        setList(books);
    }

    public void addBook(Book book)
    {
        book.setId(nextId++);
        list.add(book);
    }

    public void setList(List<Book> list) {
        this.list = list;
    }
}
