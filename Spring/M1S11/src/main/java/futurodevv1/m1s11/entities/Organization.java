package futurodevv1.m1s11.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@Entity
@Table(name = "organizations")
public class Organization
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String contact;

}
