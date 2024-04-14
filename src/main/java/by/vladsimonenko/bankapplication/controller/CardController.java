package by.vladsimonenko.bankapplication.controller;


import by.vladsimonenko.bankapplication.dto.CardResponseDto;
import by.vladsimonenko.bankapplication.dto.CreateCardRequestDto;
import by.vladsimonenko.bankapplication.dto.CreateCardResponseDto;
import by.vladsimonenko.bankapplication.mapper.CardMapper;
import by.vladsimonenko.bankapplication.model.Card;
import by.vladsimonenko.bankapplication.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients/{clientId}/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
    private final CardMapper cardMapper;

    @GetMapping
    public List<CardResponseDto> findAllCardsByClientId(@PathVariable("clientId") Integer clientId) {
        List<Card> allCardsByClientId = cardService.findAllCardsByClientId(clientId);

        return cardMapper.toDto(allCardsByClientId);
    }

    @GetMapping("/{cardId}")
    public CardResponseDto findCardById(@PathVariable("clientId") Integer clientId, @PathVariable("cardId") Integer cardId) {
        Card card = cardService.findById(cardId);

        //TODO check if cardID is THIS user card
        return cardMapper.toDto(card);
    }

    @PostMapping
    public CreateCardResponseDto createCard(
            @PathVariable("clientId") Integer clientId,
            @RequestBody @Validated CreateCardRequestDto request) {
        Card toCreate = cardMapper.toEntity(request);
        Card created = cardService.create(toCreate, clientId);

        return cardMapper.toCreateCardDto(created);
    }

}
