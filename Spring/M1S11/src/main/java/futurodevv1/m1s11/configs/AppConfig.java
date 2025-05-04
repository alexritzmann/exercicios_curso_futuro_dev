package futurodevv1.m1s11.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class AppConfig
{
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
