package futurodevv1.m1s09.repositories;

import futurodevv1.m1s09.entities.CollectionPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionPointRepository extends JpaRepository<CollectionPoint, Long>
{
    @Query
        ("SELECT DISTINCT cp FROM CollectionPoint cp " +
        "JOIN cp.materialList cpm " +
        "JOIN cpm.electronicWaste ew " +
        "WHERE LOWER(ew.type) LIKE LOWER(concat('%', :name, '%'))")
    List<CollectionPoint> findByElectronicWasteNameContaining(@Param("name") String name);
}
