package my.samples.springsecurity.domain.user;

import java.util.*;

public interface UserService {

    Optional<User> findByName(String username);

    User updatePassword(String username, String newPassword);

    String encryptPassword(CharSequence rawPassword);

}
