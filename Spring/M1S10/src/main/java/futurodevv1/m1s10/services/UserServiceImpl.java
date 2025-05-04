package futurodevv1.m1s10.services;

import futurodevv1.m1s10.dtos.UserRequestDto;
import futurodevv1.m1s10.dtos.UserResponseDto;
import futurodevv1.m1s10.entities.User;
import futurodevv1.m1s10.enums.UserRole;
import futurodevv1.m1s10.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
    private static final String DEFAULT_USER = "root";
    private static final String DEFAULT_PASS = "admin";

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUsername(username);
        if (user.isPresent()) {
            return user.get();
        }

        if (username.equals(DEFAULT_USER)) {
            return User.builder()
                    .id(0L)
                    .name("ROOT")
                    .username(DEFAULT_USER)
                    .password(encoder.encode(DEFAULT_PASS))
                    .role(UserRole.ADMIN)
                    .build();
        }

        throw new UsernameNotFoundException(username);
    }

    @Override
    public List<UserResponseDto> findAll()
    {
        return repository.findAll().stream().map(
                user -> UserResponseDto.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .username(user.getUsername())
                        .role(user.getRole())
                        .build()
        ).toList();
    }

    @Override
    public UserResponseDto findById(Long id)
    {
        User user = repository.findById(id).orElseThrow();

        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }

    @Override
    public UserResponseDto create(UserRequestDto dto)
    {
        User user = new User();
        user.setName(dto.name());
        user.setUsername(dto.username());
        user.setPassword(encoder.encode(dto.password()));
        user.setRole(dto.role());

        user = repository.save(user);

        return findById(user.getId());
    }

    @Override
    public UserResponseDto update(UserRequestDto dto, Long id)
    {
        User user = repository.findById(id).orElseThrow();
        user.setName(dto.name());
        user.setUsername(dto.username());
        user.setPassword(encoder.encode(dto.password()));
        user.setRole(dto.role());

        user = repository.save(user);

        return findById(user.getId());
    }

    @Override
    public void delete(Long id)
    {
        findById(id);
        repository.deleteById(id);
    }

}

