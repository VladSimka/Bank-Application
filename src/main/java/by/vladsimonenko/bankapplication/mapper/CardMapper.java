package by.vladsimonenko.bankapplication.mapper;

import by.vladsimonenko.bankapplication.dto.CardRequestDto;
import by.vladsimonenko.bankapplication.dto.CreateCardRequestDto;
import by.vladsimonenko.bankapplication.dto.CreateCardResponseDto;
import by.vladsimonenko.bankapplication.model.Card;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CardMapper {

    Card toEntity(CreateCardRequestDto dto);

    CreateCardResponseDto toCreateCardDto(Card card);

    CardRequestDto toDto(Card card);

    List<CardRequestDto> toDto(List<Card> cards);
}
