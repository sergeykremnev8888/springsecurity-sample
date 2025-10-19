package my.samples.springsecurity.domain.user.dao;

import java.util.*;

public interface UserDao {

    Optional<UserEntity> findByName(String name);

    void updatePassword(String username, String newPassword);

}
