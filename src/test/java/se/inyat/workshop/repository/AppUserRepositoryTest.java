package se.inyat.workshop.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;
import se.inyat.workshop.data.entity.AppUser;
import se.inyat.workshop.data.entity.Details;

import java.time.LocalDate;

@DataJpaTest
public class AppUserRepositoryTest {
    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    DetailsRepository detailsRepository;

    @Transactional
    @Test
    public void testSaveAndFindUserByUsername() {
        Details userDetails = new Details("inyat.n@gmail.se", "inyat", LocalDate.now());
        AppUser appUser = new AppUser("inyat", "inyat");

        AppUser savedUser = appUserRepository.save(appUser);
        Assertions.assertNotNull(savedUser);
        Assertions.assertNotNull(savedUser.getId());
        Assertions.assertEquals(appUser, appUserRepository.findAppUserByUsername("inyat"));

    }

}
