package by.vladsimonenko.bankapplication.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationRequestDto {
    private String username;
    private String password;
}
