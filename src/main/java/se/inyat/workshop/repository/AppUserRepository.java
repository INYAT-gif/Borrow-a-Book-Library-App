package se.inyat.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.inyat.workshop.data.entity.AppUser;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    //CRUD operations created automatically via JpaRepo
    AppUser findAppUserByUsername(String username);
    List<AppUser> findAppUserByRegDateBetween(LocalDate startDate, LocalDate endDate);
    AppUser findAppUserByUserDetails_Id(int id);
    AppUser findAppUserByUserDetails_EmailIgnoreCase(String email);


}
