package se.inyat.workshop.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;
import se.inyat.workshop.data.entity.Details;

import java.time.LocalDate;
import java.util.Optional;

@DataJpaTest
public class DetailsRepositoryTest {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    DetailsRepository detailsRepository;

    @Transactional
    @Test
    public void testFindDetailsByEmail() {
        Details userDetails = new Details("inyat.n@gmail.se", "inyat", LocalDate.now());

        Details savedDetails = detailsRepository.save(userDetails);
        Optional<Details> foundDetails = Optional.of(detailsRepository.findDetailsByEmail("inyat.n@gmail.se"));
        Assertions.assertTrue(foundDetails.isPresent());
    }
}
