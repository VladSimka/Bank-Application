package by.vladsimonenko.bankapplication.util;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Named("AuthMapperUtil")
@Component
@RequiredArgsConstructor
public class AuthMapperUtil {

    private final PasswordEncoder passwordEncoder;

    @Named("getEncodedPassword")
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
