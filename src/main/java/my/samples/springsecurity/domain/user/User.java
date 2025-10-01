package my.samples.springsecurity.domain.user;

import java.util.*;

import org.thymeleaf.util.StringUtils;

public class User {

    private long userId;
    private String name;
    private String password;
    private boolean disabled;
    private boolean mustChangePassword;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isMustChangePassword() {
        return mustChangePassword;
    }

    public void setMustChangePassword(boolean mustChangePassword) {
        this.mustChangePassword = mustChangePassword;
    }

    @Override
    public int hashCode() {
        return Objects.hash(StringUtils.toUpperCase(name, Locale.ROOT));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        User other = (User) obj;
        return Objects.equals(StringUtils.toUpperCase(name, Locale.ROOT),
                              StringUtils.toUpperCase(other.name, Locale.ROOT));
    }

}
