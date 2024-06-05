package se.inyat.workshop.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.inyat.workshop.data.entity.Details;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DetailsRepositoryTest {

    @Autowired
    private DetailsRepository detailsRepository;

    @Test
    public void testSaveAndFindById() {
        Details details = new Details("test@example.com", "John Doe", LocalDate.of(1990, 1, 1));
        detailsRepository.save(details);

        Optional<Details> foundDetails = detailsRepository.findById(details.getId());
        assertThat(foundDetails).isPresent();
        assertThat(foundDetails.get().getEmail()).isEqualTo("test@example.com");
    }

    @Test
    public void testFindByEmail() {
        Details details = new Details("test@example.com", "John Doe", LocalDate.of(1990, 1, 1));
        detailsRepository.save(details);

        Details foundDetails = detailsRepository.findDetailsByEmail("test@example.com");
        assertThat(foundDetails).isNotNull();
        assertThat(foundDetails.getName()).isEqualTo("John Doe");
    }

    @Test
    public void testFindByNameContains() {
        Details details = new Details("test@example.com", "John Doe", LocalDate.of(1990, 1, 1));
        detailsRepository.save(details);

        Details foundDetails = detailsRepository.findDetailsByNameContains("John");
        assertThat(foundDetails).isNotNull();
        assertThat(foundDetails.getEmail()).isEqualTo("test@example.com");
    }

    @Test
    public void testFindByNameIgnoreCase() {
        Details details = new Details("test@example.com", "john doe", LocalDate.of(1990, 1, 1));
        detailsRepository.save(details);

        Details foundDetails = detailsRepository.findDetailsByNameIgnoreCase("JOHN DOE");
        assertThat(foundDetails).isNotNull();
        assertThat(foundDetails.getEmail()).isEqualTo("test@example.com");
    }
}
