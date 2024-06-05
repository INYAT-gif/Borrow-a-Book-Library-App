package se.inyat.workshop.data.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    private Book book;

    @BeforeEach
    public void setUp() {
        book = new Book("1234567890", "Test Title", 14);
    }

    @Test
    public void testBookConstructorAndGetters() {
        assertEquals("1234567890", book.getIsbn());
        assertEquals("Test Title", book.getTitle());
        assertEquals(14, book.getMaxLoanDays());
    }

    @Test
    public void testSetters() {
        book.setIsbn("0987654321");
        book.setTitle("New Title");
        book.setMaxLoanDays(30);

        assertEquals("0987654321", book.getIsbn());
        assertEquals("New Title", book.getTitle());
        assertEquals(30, book.getMaxLoanDays());
    }

    @Test
    public void testEqualsAndHashCode() {
        Book sameBook = new Book("1234567890", "Test Title", 14);
        assertEquals(book, sameBook);
        assertEquals(book.hashCode(), sameBook.hashCode());
    }

    @Test
    public void testToString() {
        String expected = "Book(id=0, isbn=1234567890, title=Test Title, maxLoanDays=14, loans=null)";
        assertEquals(expected, book.toString());
    }
}
