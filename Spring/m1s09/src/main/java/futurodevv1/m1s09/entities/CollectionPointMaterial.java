package futurodevv1.m1s09.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "collection_points_materials")
public class CollectionPointMaterial
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "collection_point_id", nullable = false)
    private CollectionPoint collectionPoint;

    @ManyToOne
    @JoinColumn(name = "electronic_waste_id", nullable = false)
    private ElectronicWaste electronicWaste;

    @Column(nullable = false)
    private Double capacityMax;
}
