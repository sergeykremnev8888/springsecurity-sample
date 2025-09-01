package my.samples.springsecurity.web.security;

import org.springframework.security.core.userdetails.*;

import my.samples.springsecurity.domain.user.User;
import my.samples.springsecurity.domain.user.UserService;

public class UserDetailsPasswordServiceImpl implements UserDetailsPasswordService {

    private final UserService userService;

    public UserDetailsPasswordServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        User updatedUser = userService.updatePassword(user.getUsername(), newPassword);
        return new UserDetailsImpl(updatedUser);
    }

}
