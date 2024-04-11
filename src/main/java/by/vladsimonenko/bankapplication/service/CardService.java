package by.vladsimonenko.bankapplication.service;

import by.vladsimonenko.bankapplication.model.Card;

import java.util.List;

public interface CardService {

    Card create(Card card, Integer clientId);

    Card findById(Integer id);

    void deleteById(Integer id);

    List<Card> findAllCardsByClientId(Integer clientId);
}
