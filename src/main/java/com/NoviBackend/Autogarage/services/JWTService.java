package com.NoviBackend.Autogarage.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {

    String extractUserName(String token);

    boolean isTokenValid(String token, UserDetails userDetails);
}
