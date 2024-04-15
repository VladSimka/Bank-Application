package by.vladsimonenko.bankapplication.mapper;

import by.vladsimonenko.bankapplication.dto.RegisterRequestDto;
import by.vladsimonenko.bankapplication.model.Client;
import by.vladsimonenko.bankapplication.model.Role;
import by.vladsimonenko.bankapplication.util.AuthMapperUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {AuthMapperUtil.class},imports = {Role.class})
public interface AuthMapper {

    @Mapping(target = "password",
            qualifiedByName = {"AuthMapperUtil", "getEncodedPassword"}, source = "password")
    @Mapping(target = "role", expression = "java(Role.USER)")
    Client toEntity(RegisterRequestDto registerRequestDto);
}
