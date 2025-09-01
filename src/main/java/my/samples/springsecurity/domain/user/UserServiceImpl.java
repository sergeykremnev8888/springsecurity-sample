package my.samples.springsecurity.domain.user;

import java.util.*;
import java.util.function.BiFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.samples.springsecurity.domain.user.dao.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
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

        return userDao.encryptPassword(rawPassword.toString());
    }

    @Override
    public List<User> findAllUsers() {
        //Demo implementation
        BiFunction<Long, String, User> getUser = (id, name) -> {
            User user = new User();
            user.setUserId(id);
            user.setName(name);
            return user;
        };
        return List.of(getUser.apply(1L, "Sample User 1"),
                       getUser.apply(2L, "Sample User 2"),
                       getUser.apply(3L, "Sample User 3"));
    }

    private User toUser(UserEntity entity) {
        User user = new User();
        user.setName(entity.getName());
        user.setPassword(entity.getPassword());
        user.setUserId(entity.getUserId());
        return user;
    }
}
