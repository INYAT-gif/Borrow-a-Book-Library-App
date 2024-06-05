package se.inyat.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.inyat.workshop.data.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    //Basic CRUD operations automatically via Jpa
    Book findBookByIsbnIgnoreCase(String isbn);
    Book findBookByTitleContains(String title);
    List<Book> findBooksByMaxLoanDaysLessThan(int days);
//add more as needed
}
