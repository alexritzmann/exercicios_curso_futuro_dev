package futurodevv1.m1s11.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig
{
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtFilter jwtFilter) throws Exception
    {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .formLogin(AbstractHttpConfigurer::disable)
                .sessionManagement((s) -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Gerenciamento de sessão STATELESS
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
                        .anyRequest().authenticated())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
    {
        return config.getAuthenticationManager();
    }

}