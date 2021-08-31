package pl.coderslab;

import java.util.List;

public interface BookService {

  List<Book> getList();
  Book getBookById(Long id);
  void deleteBook(Long id);
  void addBook(Book book);
  void editBook(Book book);

}

