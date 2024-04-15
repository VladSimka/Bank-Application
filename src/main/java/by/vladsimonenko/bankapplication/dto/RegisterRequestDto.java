package by.vladsimonenko.bankapplication.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequestDto {

    private String name;

    private String username;

    private String password;
}
