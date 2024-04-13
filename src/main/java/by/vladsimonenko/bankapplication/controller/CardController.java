package by.vladsimonenko.bankapplication.controller;

import by.vladsimonenko.bankapplication.dto.CreateCardRequestDto;
import by.vladsimonenko.bankapplication.dto.CreateCardResponseDto;
import by.vladsimonenko.bankapplication.mapper.CardMapper;
import by.vladsimonenko.bankapplication.model.Card;
import by.vladsimonenko.bankapplication.service.CardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients/{clientId}/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
    private final CardMapper cardMapper;

    @GetMapping
    public List<Card> getCards(@PathVariable("clientId") Integer clientId) {

        return cardService.findAllCardsByClientId(clientId);
    }

    @PostMapping
    public CreateCardResponseDto createCard(
            @PathVariable("clientId") Integer clientId,
            @RequestBody @Valid CreateCardRequestDto request) {
        Card toCreate = cardMapper.toEntity(request);
        Card created = cardService.create(toCreate, clientId);

        return cardMapper.toCreateCardDto(created);
    }

}
