package my.samples.springsecurity.domain.user.dao;

import java.util.Objects;

import my.samples.springsecurity.utils.StringUtils;

public class UserEntity {

    private long userId;
    private String userName;
    private String password;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(StringUtils.toUpperCase(userName));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        UserEntity other = (UserEntity) obj;
        return StringUtils.equalsIgnoreCase(userName, other.userName);
    }
}
