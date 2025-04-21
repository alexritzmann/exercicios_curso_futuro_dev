package futurodevv1.m1s08.repositories;

import futurodevv1.m1s08.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>
{

    @Query
    ("SELECT p FROM Project p JOIN p.organization o WHERE " +
    "(CAST(:region AS text) IS NULL OR LOWER(p.region) LIKE LOWER(CONCAT('%', CAST(:region AS text), '%'))) AND " +
    "(CAST(:organizationName AS text) IS NULL OR LOWER(o.name) LIKE LOWER(CONCAT('%', CAST(:organizationName AS text), '%')))")

    List<Project> findFiltered(@Param("region") String region, @Param("organizationName") String organizationName);

}
