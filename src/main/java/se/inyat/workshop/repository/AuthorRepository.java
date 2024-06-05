package se.inyat.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.inyat.workshop.data.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Author findAuthorByFirstName(String firstName);
    Author findAuthorByLastName(String lastName);
    Author findAuthorByFirstNameOrLastNameContaining(String firstName, String lastName);
    //more as needed

}
