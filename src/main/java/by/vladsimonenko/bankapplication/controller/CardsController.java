package by.vladsimonenko.bankapplication.controller;

import by.vladsimonenko.bankapplication.model.Card;
import by.vladsimonenko.bankapplication.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients/{clientId}/cards")
@RequiredArgsConstructor
public class CardsController {
    private final CardService cardService;

    @GetMapping
    public List<Card> getCards(@PathVariable("clientId") Integer clientId) {

        return cardService.findAllCardsByClientId(clientId);
    }

}
