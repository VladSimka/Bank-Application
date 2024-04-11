package by.vladsimonenko.bankapplication.mapper;

import by.vladsimonenko.bankapplication.dto.ClientResponseDto;
import by.vladsimonenko.bankapplication.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMapper {

    ClientResponseDto toDto(Client client);
}
