package my.samples.springsecurity.domain.user;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.util.*;

import org.springframework.stereotype.Service;

import my.samples.springsecurity.domain.user.dao.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Optional<User> findByName(String username) {
        Objects.requireNonNull(username);

        return userDao.findByName(username).map(this::toUser);
    }

    @Override
    public User updatePassword(String username, String newPassword) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(newPassword);

        userDao.updatePassword(username, newPassword);
        return userDao.findByName(username)
                      .map(this::toUser)
                      .orElseThrow(() -> new UserException("User not found: username=[%s]", username));
    }

    @Override
    public String encryptPassword(CharSequence rawPassword) {
        Objects.requireNonNull(rawPassword);
        byte[] stringBytes = rawPassword.toString().getBytes(UTF_8);
        return Base64.getEncoder().encodeToString(stringBytes);
    }

    private User toUser(UserEntity entity) {
        User user = new User();
        user.setName(entity.getUserName());
        user.setPassword(entity.getPassword());
        user.setUserId(entity.getUserId());
        return user;
    }
}
