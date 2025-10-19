package my.samples.springsecurity.web.security;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import my.samples.springsecurity.domain.user.User;

@SuppressWarnings("serial")
public class UserDetailsImpl implements UserDetails {

    private final User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("DEFAULT"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.isDisabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !user.isMustChangePassword();
    }

    @Override
    public boolean isEnabled() {
        return !user.isDisabled();
    }

}
