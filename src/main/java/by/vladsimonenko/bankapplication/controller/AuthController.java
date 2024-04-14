package by.vladsimonenko.bankapplication.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {


    @PostMapping("/register")
    public AuthenticationResponseDto register(@RequestBody RegisterRequestDto request) {
        //todo
    }


    @PostMapping("/login")
    public AuthenticationResponseDto register(@RequestBody AuthenticationRequestDto request) {
        //todo
    }
}
