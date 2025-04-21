package futurodevv1.m1s08.repositories;

import futurodevv1.m1s08.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>
{


}
