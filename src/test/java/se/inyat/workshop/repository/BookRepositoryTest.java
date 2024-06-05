package se.inyat.workshop.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import se.inyat.workshop.data.entity.Book;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testFindBookByIsbnIgnoreCase() {
        Book book = new Book("1234567890", "Test Title", 14);
        bookRepository.save(book);

        Book foundBook = bookRepository.findBookByIsbnIgnoreCase("1234567890");
        assertNotNull(foundBook);
        assertEquals("Test Title", foundBook.getTitle());
    }

    @Test
    public void testFindBookByTitleContains() {
        Book book = new Book("1234567890", "Unique Title", 14);
        bookRepository.save(book);

        Book foundBook = bookRepository.findBookByTitleContains("Unique");
        assertNotNull(foundBook);
        assertEquals("1234567890", foundBook.getIsbn());
    }

    @Test
    public void testFindBooksByMaxLoanDaysLessThan() {
        Book book1 = new Book("1234567890", "Test Title 1", 10);
        Book book2 = new Book("0987654321", "Test Title 2", 20);
        bookRepository.save(book1);
        bookRepository.save(book2);

        List<Book> books = bookRepository.findBooksByMaxLoanDaysLessThan(15);
        assertEquals(1, books.size());
        assertEquals("1234567890", books.get(0).getIsbn());
    }
}
