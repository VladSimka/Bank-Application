package by.vladsimonenko.bankapplication.dto;

import jakarta.validation.constraints.Pattern;

public record CreateCardRequestDto(
        @Pattern(regexp = "^(0[1-9]|1[0-2])/([2-9][5-9]|[3-9][0-9])$",
                message = "bank.cards.create.errors.date_is_invalid")
        String date) {
}
