package my.samples.springsecurity.web.security;

import java.util.Objects;

import org.springframework.security.crypto.password.PasswordEncoder;

import my.samples.springsecurity.domain.user.UserService;
import my.samples.springsecurity.utils.StringUtils;

public class DaoPasswordEncoder implements PasswordEncoder {

    private final UserService userService;

    public DaoPasswordEncoder(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String encode(CharSequence rawPassword) {
        Objects.requireNonNull(rawPassword);
        return userService.encryptPassword(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return StringUtils.isNotBlank(rawPassword) && encode(rawPassword).equals(encodedPassword);
    }

}
