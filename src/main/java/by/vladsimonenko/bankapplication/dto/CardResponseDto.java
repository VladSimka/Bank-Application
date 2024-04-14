package by.vladsimonenko.bankapplication.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public record CardResponseDto(
        String number,
        String date,
        BigDecimal balance,
        BigDecimal monthLimit,
        Timestamp dateOfSettingLimit,
        Boolean limitExceeded) {
}
