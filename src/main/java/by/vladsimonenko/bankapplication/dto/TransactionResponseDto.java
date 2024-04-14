package by.vladsimonenko.bankapplication.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public record TransactionResponseDto(
        String fromNumber,
        String toNumber,
        String currency,
        Timestamp date,
        BigDecimal amount) {
}
