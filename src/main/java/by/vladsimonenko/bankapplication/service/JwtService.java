package by.vladsimonenko.bankapplication.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JwtService {

    boolean isTokenValid(String token, UserDetails userDetails);

    String extractUsername(String token);

    String generateToken(Map<String, Object> claims, UserDetails userDetails);
}
