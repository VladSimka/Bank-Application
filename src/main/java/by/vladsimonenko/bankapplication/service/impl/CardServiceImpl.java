package by.vladsimonenko.bankapplication.service.impl;

import by.vladsimonenko.bankapplication.model.Card;
import by.vladsimonenko.bankapplication.repository.CardRepository;
import by.vladsimonenko.bankapplication.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;


    @Transactional
    @Override
    public Card create(Card card, Integer clientId) {
        card.setNumber(generateCardNumber());
        card.setCvv(generateCardCVV());
        card.setBalance(BigDecimal.ZERO);
        card.setMonthLimit(BigDecimal.valueOf(1000));
        card.setDateOfSettingLimit(Timestamp.valueOf(LocalDateTime.now()));
        card.setLimitExceeded(Boolean.FALSE);

        card = cardRepository.save(card);
        cardRepository.connectCardToClient(card.getId(), clientId);
        cardRepository.connectCardToAccount(card.getId(), clientId);
        log.info(card.toString());

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

    private static String generateCardNumber() {
        Random random = new Random();
        StringBuilder cardNumberBuilder = new StringBuilder();


        for (int i = 0; i < 16; i++) {
            if (i > 0 && i % 4 == 0) {
                cardNumberBuilder.append("-");
            }
            int digit = random.nextInt(10);
            cardNumberBuilder.append(digit);
        }

        return cardNumberBuilder.toString();
    }

    private static String generateCardCVV() {
        Random random = new Random();
        StringBuilder cardCVVBuilder = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            int digit = random.nextInt(9) + 1;
            cardCVVBuilder.append(digit);
        }

        return cardCVVBuilder.toString();
    }
}

