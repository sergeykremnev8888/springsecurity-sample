package my.samples.springsecurity.domain.user.dao.h2;

import java.util.*;

import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import my.samples.springsecurity.domain.user.dao.*;

@Repository
public class UserDaoH2 implements UserDao {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<UserEntity> rowMapper = new BeanPropertyRowMapper<>(UserEntity.class);

    public UserDaoH2(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<UserEntity> findByName(String name) {
        String sql = "select user_id, user_name, password from users where user_name = ?";
        List<UserEntity> list = jdbcTemplate.query(sql, new RowMapperResultSetExtractor<>(rowMapper, 1), name);

        Optional<UserEntity> userEntity;
        if (list.isEmpty()) {
            userEntity = Optional.empty();

        } else if (list.size() == 1) {
            userEntity = Optional.of(list.get(0));

        } else {
            throw new DaoUserException("Multiple users found: expected=[%d], found=[%d]", 1, list.size());
        }
        return userEntity;
    }

    @Override
    public void updatePassword(String username, String newPassword) {
        String sql = "update users set password = ? where user_name = ?";
        int affectedRows = jdbcTemplate.update(sql, newPassword, username);
        if (affectedRows == 0) {
            throw new DaoUserException("Password not updated: username=[%s]", username);
        } else if (affectedRows > 1) {
            throw new DaoUserException("Multiple passwords updated: count=[%d]", affectedRows);
        }
    }

}
