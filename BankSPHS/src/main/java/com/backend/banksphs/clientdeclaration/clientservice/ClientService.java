package com.backend.banksphs.clientdeclaration.clientservice;

import com.backend.banksphs.clientdeclaration.cliententity.Client;
import com.backend.banksphs.clientdeclaration.clientrepository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public void addNewClient(Client client) {
        Optional<Client> clientByIdNumber = clientRepository.findClientByIdNumber(client.getIdNum());
        if (clientByIdNumber.isPresent()){
           throw new IllegalStateException("Alredy Registered");
        }
        clientRepository.save(client);
    }

    public void deleteClient(Long clientId) {
        boolean exists = clientRepository.existsById(clientId);
        if (!exists){
            throw new IllegalStateException("Client "+clientId+" does not exist" );
        }
        clientRepository.deleteById(clientId);
    }

    @Transactional
    public void updateClient(Long clientId, Long idNum, String idType,
                             String name, String surname,
                             String email, LocalDate dod) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalStateException("Client with id " + clientId + " does not exist"));
        if (name != null && name.length() > 0 && !Objects.equals(client.getName(), name)){
            client.setName(name);
        }
        if (surname != null && surname.length() > 0 && !Objects.equals(client.getSurname(), surname)){
            client.setSurname(surname);
        }
        if (email != null && email.length() > 0 && !Objects.equals(client.getEmail(), email)){
            client.setEmail(email);
        }
        if (dod != null && !Objects.equals(client.getDod(), dod)){
            client.setDod(dod);
        }
        if (idType != null && idType.length() > 0 && !Objects.equals(client.getIdType(), idType)){
            client.setIdType(idType);
        }
        if (idNum != null && idNum > 0 && !Objects.equals(client.getIdNum(), idNum)){
            Optional<Client> clientOpcional = clientRepository.findClientByIdNumber(idNum);
            if (clientOpcional.isPresent()) {
                throw new IllegalStateException("ID Number already Registered");
            }
            client.setIdNum(idNum);
        }
    }
}
