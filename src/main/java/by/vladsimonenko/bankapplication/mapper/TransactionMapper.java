package by.vladsimonenko.bankapplication.mapper;

import by.vladsimonenko.bankapplication.dto.TransactionResponseDto;
import by.vladsimonenko.bankapplication.model.BankTransaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransactionMapper {

    @Mapping(target = "fromNumber",
            expression = "java(transaction.getFrom().getNumber())")
    @Mapping(target = "toNumber",
            expression = "java(transaction.getTo().getNumber())")
    TransactionResponseDto toDto(BankTransaction transaction);

    List<TransactionResponseDto> toDto(List<BankTransaction> transactions);
}
