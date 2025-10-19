package my.samples.springsecurity.config;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.*;
import org.springframework.security.authorization.*;
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
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> 
                authorize.requestMatchers("/css/**").permitAll()
                     .anyRequest().authenticated())
            .formLogin(form ->
                form.loginPage("/login").permitAll().defaultSuccessUrl("/"))
            .logout(logout -> 
                logout.logoutSuccessUrl("/login?logout").permitAll());

        return http.build();
    }

    @Bean
    AuthorizationEventPublisher authorizationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        return new SpringAuthorizationEventPublisher(applicationEventPublisher);
    }

    @Bean
    PasswordEncoder passwordEncoder(UserService userService) {
        PasswordEncoder legacyEncoder = new DaoPasswordEncoder(userService);
        PasswordEncoder newEncoder = new BCryptPasswordEncoder();
        return new RecryptablePasswordEncoder(legacyEncoder, newEncoder);
    }

    @Bean
    UserDetailsPasswordService userDetailsPasswordService(UserService userService) {
        return new UserDetailsPasswordServiceImpl(userService);
    }

    @Bean
    UserDetailsService userDetailsService(UserService userService) {
        return new DaoUserDetailsService(userService);
    }

    
}
