package futurodevv1.m1s10.configs;

import futurodevv1.m1s10.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig
{

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception
    {
        AuthenticationManagerBuilder builder = http.getSharedObject(AuthenticationManagerBuilder.class);

        builder.userDetailsService(userService).passwordEncoder(passwordEncoder);
        return builder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .formLogin(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/organizations").hasAnyAuthority("ADMIN", "USER")
                        .requestMatchers(HttpMethod.POST, "/organizations").hasAnyAuthority("ADMIN", "USER")
                        .requestMatchers(HttpMethod.PUT, "/organizations/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/organizations/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/users").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/users").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/users/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/users/**").hasAuthority("ADMIN")
                        .anyRequest().authenticated()
                );
        return http.build();
    }

    // CONFIGURAÇÃO INICIAL
/*
    @Bean
    CommandLineRunner initAdmin(UserRepository userRepository, PasswordEncoder encoder)
    {
        return args ->
        {
            if (userRepository.findByUsername("alex").isEmpty())
            {
                User admin = User.builder()
                        .name("alex")
                        .username("alex")
                        .password(encoder.encode("alex"))
                        .role(UserRole.ADMIN)
                        .build();
                userRepository.save(admin);
            }
        };
    }
*/

}