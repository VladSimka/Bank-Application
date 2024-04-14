package by.vladsimonenko.bankapplication.dto;

import java.math.BigDecimal;

public record AccountResponseDto(
        Long number,
        BigDecimal balance) {

}
