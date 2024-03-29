package com.fiap.burger.controller.controller;

import com.fiap.burger.controller.adapter.api.ClientController;
import com.fiap.burger.entity.client.Client;
import com.fiap.burger.usecase.adapter.usecase.ClientUseCase;
import com.fiap.burger.usecase.misc.exception.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class DefaultClientController implements ClientController {
    @Autowired
    private ClientUseCase useCase;

    public Client findById(@PathVariable Long clientId) {
        var persistedClient = useCase.findById(clientId);
        if (persistedClient == null) throw new ClientNotFoundException(clientId);
        return persistedClient;
    }

    public Client findByCpf(@PathVariable String clientCpf) {
        var persistedClient = useCase.findByCpf(clientCpf);
        if (persistedClient == null) throw new ClientNotFoundException();
        return persistedClient;
    }

    public Client insert(Client client) {
        return useCase.insert(client);
    }
}