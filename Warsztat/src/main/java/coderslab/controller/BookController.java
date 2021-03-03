package coderslab.controller;

import org.springframework.web.bind.annotation.*;
import coderslab.service.MemoryBookService;

import coderslab.model.Book;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private MemoryBookService memoryBookService;

    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @RequestMapping("")
    public List<Book> showAllBooks() {
        return memoryBookService.showAllBooks();

    }

    @GetMapping("/{id}")
    public Book showBookById(@PathVariable Long id) {
        return memoryBookService.showBookById(id);
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        memoryBookService.addBook(book);
    }


    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id) {
        memoryBookService.deleteBook(id);
    }


    @PutMapping("")
    public void deleteBook(@RequestBody Book updatedBook) {
        memoryBookService.updateBook(updatedBook);
    }

}