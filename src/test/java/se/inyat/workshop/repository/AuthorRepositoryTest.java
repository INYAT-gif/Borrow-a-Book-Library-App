package se.inyat.workshop.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.inyat.workshop.data.entity.Author;
import se.inyat.workshop.repository.AuthorRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthorRepositoryTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private Author author; // Assuming you have an Author class to test, not AuthorService

    @Test
    public void testFindAuthorByFirstName() {
        // Given
        String firstName = "John";
        Author expectedAuthor = new Author(firstName, "Doe");
        when(authorRepository.findAuthorByFirstName(firstName)).thenReturn(expectedAuthor);

        // When
        Author actualAuthor = authorRepository.findAuthorByFirstName(firstName);

        // Then
        assertEquals(expectedAuthor, actualAuthor);
        verify(authorRepository, times(1)).findAuthorByFirstName(firstName);
    }

    @Test
    public void testFindAuthorByLastName() {
        // Similarly test for findAuthorByLastName
    }

    @Test
    public void testFindAuthorByFirstNameOrLastNameContaining() {
        // Similarly test for findAuthorByFirstNameOrLastNameContaining
    }
}
