package futurodevv1.m1s09.repositories;

import futurodevv1.m1s09.entities.CollectionPointMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionPointMaterialRepository extends JpaRepository<CollectionPointMaterial, Long> {
}