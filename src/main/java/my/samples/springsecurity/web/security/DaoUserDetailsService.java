package my.samples.springsecurity.web.security;

import org.springframework.security.core.userdetails.*;

import my.samples.springsecurity.domain.user.UserService;

public class DaoUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public DaoUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.findByName(username)
                          .map(UserDetailsImpl::new)
                          .orElseThrow(() -> new UsernameNotFoundException("User not found: [%s]".formatted(username)));
    }

}
