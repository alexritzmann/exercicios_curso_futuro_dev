package futurodevv1.m1s10.services;

import futurodevv1.m1s10.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {

        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}

