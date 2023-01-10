package com.backend.banksphs.clientservice;

import com.backend.banksphs.client.Client;
import com.backend.banksphs.clientrepository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClient(){
        return clientRepository.findAll();
    }

}
