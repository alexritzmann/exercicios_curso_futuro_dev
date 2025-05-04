package futurodevv1.m1s11.entities;

import futurodevv1.m1s11.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return List.of(()->role.name());
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return isEnabled();
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return isEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return isEnabled();
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }
}
