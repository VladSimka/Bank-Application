package by.vladsimonenko.bankapplication.dto;

public record CreateCardResponseDto(
        String number,
        String date,
        String cvv) {
}
