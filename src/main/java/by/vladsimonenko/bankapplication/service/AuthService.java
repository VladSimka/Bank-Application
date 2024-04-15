package by.vladsimonenko.bankapplication.service;

import by.vladsimonenko.bankapplication.dto.AuthenticationRequestDto;
import by.vladsimonenko.bankapplication.dto.AuthenticationResponseDto;
import by.vladsimonenko.bankapplication.dto.RegisterRequestDto;

public interface AuthService {
    AuthenticationResponseDto register(RegisterRequestDto request);

    AuthenticationResponseDto authenticate(AuthenticationRequestDto request);

}
