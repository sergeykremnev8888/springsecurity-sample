package my.samples.springsecurity.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import my.samples.springsecurity.domain.user.UserService;
import my.samples.springsecurity.web.security.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(requests -> requests.requestMatchers("/", "/home").permitAll()
                                                              .anyRequest().authenticated())
                   .formLogin(form -> form.loginPage("/login").permitAll())
                   .logout(logout -> logout.permitAll())
                   .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(UserService userService) {
        PasswordEncoder legacyEncoder = new DaoPasswordEncoder(userService);
        PasswordEncoder newEncoder = new BCryptPasswordEncoder();
        return new OwnPasswordEncoder(legacyEncoder, newEncoder);
    }

    @Bean
    public UserDetailsPasswordService userDetailsPasswordService(UserService userService) {
        return new UserDetailsPasswordServiceImpl(userService);
    }

    @Bean
    public UserDetailsService userDetailsService(UserService userService) {
        return new DaoUserDetailsService(userService);
    }

}
