package se.inyat.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.inyat.workshop.data.entity.BookLoan;

import java.util.List;

@Repository
public interface BookLoanRepository extends JpaRepository<BookLoan, Integer> {

    //Basic CRUD automatically

    List<BookLoan> findBookLoansByBookId(int id);
}
