package by.vladsimonenko.bankapplication.service.impl;

import by.vladsimonenko.bankapplication.dto.AuthenticationRequestDto;
import by.vladsimonenko.bankapplication.dto.AuthenticationResponseDto;
import by.vladsimonenko.bankapplication.dto.RegisterRequestDto;
import by.vladsimonenko.bankapplication.mapper.AuthMapper;
import by.vladsimonenko.bankapplication.model.Client;
import by.vladsimonenko.bankapplication.repository.ClientRepository;
import by.vladsimonenko.bankapplication.service.AuthService;
import by.vladsimonenko.bankapplication.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ClientRepository clientRepository;
    private final AuthMapper authMapper;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponseDto register(RegisterRequestDto request) {
        Client client = authMapper.toEntity(request);

        clientRepository.save(client);

        String jwtToken = jwtService.generateToken(new HashMap<>(), client);
        return AuthenticationResponseDto.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponseDto authenticate(AuthenticationRequestDto request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        var client = clientRepository.findByUsername(request.getUsername())
                .orElseThrow();//TODO

        String jwtToken = jwtService.generateToken(new HashMap<>(), client);
        return AuthenticationResponseDto.builder()
                .token(jwtToken)
                .build();
    }
}
