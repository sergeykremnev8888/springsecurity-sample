package my.samples.springsecurity.web.security;

import java.util.Objects;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Allows to log in with a legacy password encoder and recrypt the password
 * using a new password encoder implicitly for a user.
 */
public class RecryptablePasswordEncoder implements PasswordEncoder {

    private final PasswordEncoder legacyEncoder;
    private final PasswordEncoder newEncoder;

    public RecryptablePasswordEncoder(PasswordEncoder legacyEncoder, PasswordEncoder newEncoder) {
        this.legacyEncoder = Objects.requireNonNull(legacyEncoder);
        this.newEncoder = Objects.requireNonNull(newEncoder);
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return newEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return newEncoder.matches(rawPassword, encodedPassword)
            || legacyEncoder.matches(rawPassword, encodedPassword);
    }

    @Override
    public boolean upgradeEncoding(String encodedPassword) {
        try {
            return newEncoder.upgradeEncoding(encodedPassword);
        } catch (IllegalArgumentException e) {
            //This is a legacy password which has to be encoded with the new encoder.
            return true;
        }
    }

}
