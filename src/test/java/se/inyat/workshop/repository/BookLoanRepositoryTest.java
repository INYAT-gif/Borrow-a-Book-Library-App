package se.inyat.workshop.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.inyat.workshop.data.entity.AppUser;
import se.inyat.workshop.data.entity.Book;
import se.inyat.workshop.data.entity.BookLoan;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class BookLoanRepositoryTest {

    @Autowired
    private BookLoanRepository bookLoanRepository;

    @Test
    public void testSaveBookLoan() {
        // Create sample data
        AppUser borrower = new AppUser();
        // set properties of borrower
        Book book = new Book();
        // set properties of book
        LocalDate loanDate = LocalDate.now();
        LocalDate dueDate = loanDate.plusDays(7); // Example due date 7 days from now
        boolean returned = false;

        // Create a BookLoan instance
        BookLoan bookLoan = new BookLoan();
        bookLoan.setBorrower(borrower);
        bookLoan.setBook(book);
        bookLoan.setLoanDate(loanDate);
        bookLoan.setDueDate(dueDate);
        bookLoan.setReturned(returned);

        // Save the BookLoan
        BookLoan savedBookLoan = bookLoanRepository.save(bookLoan);

        // Check if savedBookLoan is not null
        assertNotNull(savedBookLoan);
    }

    @Test
    public void testFindBookLoansByBookId() {
        // Call the repository method
        List<BookLoan> bookLoans = bookLoanRepository.findBookLoansByBookId(1); // assuming book id 1 exists

        // Assert that the result is not null
        assertNotNull(bookLoans);

        // You can add further assertions as needed
        // For example, check if the list is not empty, or check specific values
        // assertEquals(expectedSize, bookLoans.size());
    }
}
