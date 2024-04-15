package by.vladsimonenko.bankapplication.service.impl;

import by.vladsimonenko.bankapplication.exception.ResourceNotFoundException;
import by.vladsimonenko.bankapplication.model.Client;
import by.vladsimonenko.bankapplication.repository.ClientRepository;
import by.vladsimonenko.bankapplication.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;


    @Override
    public Client findById(Integer id) {
        return clientRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User with id %d not found".formatted(id))
                );
    }

    @Override
    public Client findByUsername(String username) {
        return clientRepository.findByUsername(username)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User with username %s not found".formatted(username))
                );
    }

    @Transactional
    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        clientRepository.deleteById(id);
    }


}
