package se.inyat.workshop.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import se.inyat.workshop.data.entity.AppUser;
import se.inyat.workshop.data.entity.Details;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository appUserRepository;

    @Test
    public void testFindAppUserByUsername() {
        // Given
        AppUser appUser = new AppUser("testuser", "password123");
        appUserRepository.save(appUser);

        // When
        AppUser foundUser = appUserRepository.findAppUserByUsername("testuser");

        // Then
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getUsername()).isEqualTo("testuser");
    }

    @Test
    public void testFindAppUserByRegDateBetween() {
        // Given
        AppUser appUser1 = new AppUser("user1", "password1");
        appUser1.setRegDate(LocalDate.of(2023, 1, 1));
        appUserRepository.save(appUser1);

        AppUser appUser2 = new AppUser("user2", "password2");
        appUser2.setRegDate(LocalDate.of(2023, 2, 1));
        appUserRepository.save(appUser2);

        AppUser appUser3 = new AppUser("user3", "password3");
        appUser3.setRegDate(LocalDate.of(2023, 3, 1));
        appUserRepository.save(appUser3);

        // When
        List<AppUser> users = appUserRepository.findAppUserByRegDateBetween(
                LocalDate.of(2023, 1, 15),
                LocalDate.of(2023, 2, 15)
        );

        // Then
        assertThat(users).hasSize(1);
        assertThat(users.get(0).getUsername()).isEqualTo("user2");
    }


}
