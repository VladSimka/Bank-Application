package by.vladsimonenko.bankapplication.controller;


import by.vladsimonenko.bankapplication.dto.AuthenticationRequestDto;
import by.vladsimonenko.bankapplication.dto.AuthenticationResponseDto;
import by.vladsimonenko.bankapplication.dto.RegisterRequestDto;
import by.vladsimonenko.bankapplication.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthenticationResponseDto register(@RequestBody RegisterRequestDto request) {
        return authService.register(request);
    }


    @PostMapping("/login")
    public AuthenticationResponseDto authenticate(@RequestBody AuthenticationRequestDto request) {
        return authService.authenticate(request);
    }
}
