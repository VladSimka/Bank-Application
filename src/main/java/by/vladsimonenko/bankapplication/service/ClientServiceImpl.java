package by.vladsimonenko.bankapplication.service;

import by.vladsimonenko.bankapplication.exception.ResourceNotFoundException;
import by.vladsimonenko.bankapplication.model.Client;
import by.vladsimonenko.bankapplication.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;


    public Client findById(Integer id) {
        return clientRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User with id %d not found".formatted(id))
                );
    }

}
