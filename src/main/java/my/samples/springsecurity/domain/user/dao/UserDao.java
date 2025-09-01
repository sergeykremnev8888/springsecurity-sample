package my.samples.springsecurity.domain.user.dao;

import java.util.Optional;

public interface UserDao {

    Optional<UserEntity> findByName(String name);

    void updatePassword(String username, String newPassword);

    String encryptPassword(String rawPassword);

}
