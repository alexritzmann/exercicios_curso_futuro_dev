package futurodevv1.m1s08.repositories;

import futurodevv1.m1s08.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>
{

    @Query
    ("SELECT o FROM Organization o WHERE " +
    "(CAST(:name AS string) IS NULL OR LOWER(o.name) LIKE LOWER(CONCAT('%', CAST(:name AS string), '%'))) AND " +
    "(CAST(:contact AS string) IS NULL OR LOWER(o.contact) LIKE LOWER(CONCAT('%', CAST(:contact AS string), '%')))")

    List<Organization> findFiltered(@Param("name") String name, @Param("contact") String contact);
}
