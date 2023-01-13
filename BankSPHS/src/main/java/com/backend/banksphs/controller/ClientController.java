package com.backend.banksphs.controller;

import com.backend.banksphs.entity.Client;
import com.backend.banksphs.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClient(){
        return clientService.getClient();
    }

    @PostMapping
    public void registerNewClient(@RequestBody Client client){
        clientService.addNewClient(client);
    }

    @DeleteMapping(path = "{clientId}")
    public void deleteClient(@PathVariable("clientId") Long clientId){
        clientService.deleteClient(clientId);
    }

    @PutMapping(path = "{clientId}")
    public void updateClient(
            @PathVariable("clientId") Long clientId,
            @RequestParam(required = false) Long idNum,
            @RequestParam(required = false) String idType,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) LocalDate dod){
                clientService.updateClient(clientId,idNum,idType,name,surname,email,dod);
    }
}
