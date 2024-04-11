package by.vladsimonenko.bankapplication.service.impl;

import by.vladsimonenko.bankapplication.model.Card;
import by.vladsimonenko.bankapplication.repository.CardRepository;
import by.vladsimonenko.bankapplication.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;


    @Transactional
    @Override
    public Card create(Card card, Integer clientId) {
        card = cardRepository.save(card);
        cardRepository.connectCardToClient(card.getId(), clientId);

        return card;
    }

    @Override
    public Card findById(Integer id) {
        return cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card with id %d not found".formatted(id)));
    }

    @Transactional

    @Override
    public void deleteById(Integer id) {
        cardRepository.deleteById(id);
    }

    @Override
    public List<Card> findAllCardsByClientId(Integer clientId) {
        return cardRepository.findAllCardsByClientId(clientId);
    }
}
