package by.vladsimonenko.bankapplication.mapper;

import by.vladsimonenko.bankapplication.dto.AccountResponseDto;
import by.vladsimonenko.bankapplication.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccountMapper {

    AccountResponseDto toDto(Account account);
}
