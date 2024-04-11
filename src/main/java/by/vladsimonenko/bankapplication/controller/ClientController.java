package by.vladsimonenko.bankapplication.controller;

import by.vladsimonenko.bankapplication.dto.ClientResponseDto;
import by.vladsimonenko.bankapplication.mapper.ClientMapper;
import by.vladsimonenko.bankapplication.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;


    @GetMapping("/{id}")
    public ClientResponseDto findById(@PathVariable Integer id) {
        var client = clientService.findById(id);

        return clientMapper.toDto(client);
    }
}
