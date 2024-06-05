package se.inyat.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.inyat.workshop.data.entity.Details;

@Repository
public interface DetailsRepository extends JpaRepository<Details, Integer> {
    Details findDetailsByEmail(String email);
    Details findDetailsByNameContains(String name);
    Details findDetailsByNameIgnoreCase(String name);

}
