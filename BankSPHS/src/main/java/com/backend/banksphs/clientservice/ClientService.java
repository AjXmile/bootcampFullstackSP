package com.backend.banksphs.clientservice;

import com.backend.banksphs.client.Client;
import com.backend.banksphs.clientrepository.ClientRepository;
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
        Optional<Client> clientByIdNumber = clientRepository.findClientByIdNumber(client.getId_num());
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
    public void updateClient(Long clientId, Long id_num, String id_type,
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
        if (id_type != null && id_type.length() > 0 && !Objects.equals(client.getId_type(), id_type)){
            client.setId_type(id_type);
        }
        if (id_num != null && id_num > 0 && !Objects.equals(client.getId_num(), id_num)){
            Optional<Client> clientOpcional = clientRepository.findClientByIdNumber(id_num);
            if (clientOpcional.isPresent()) {
                throw new IllegalStateException("ID Number already Registered");
            }
            client.setId_num(id_num);
        }
    }
}
