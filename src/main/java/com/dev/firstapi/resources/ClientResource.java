package com.dev.firstapi.resources;

import com.dev.firstapi.models.Client;
import com.dev.firstapi.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ClientResource {
    @Autowired
    ClientRepository clientRepository;

/*

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        List<Client> list = clientRepository.findAll();
        return ResponseEntity.ok().body(list);

    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        Client client = clientRepository.findById(id).get();
        return ResponseEntity.ok().body(client);

    }
*/
    public void saveClient(@RequestBody Client client) {
        clientRepository.save(client);

    }

    public Client findId(Long id){
        Optional<Client> client = clientRepository.findById(id);
        Client clientOnData = new Client();
                if (client.isPresent()){
                    clientOnData = client.get();
                }
                return clientOnData;
    }

    public void update (Long id, Client  client) {
        Client clientOnBank = findId(id);

        if(client.getUserName() != null){
            clientOnBank.setUserName(client.getUserName());
        }
        if(client.getEmail() != null){
            clientOnBank.setEmail(client.getEmail());
        }
        if (client.getCpf()!= null){
            clientOnBank.setCpf(client.getCpf());
        }
        if(client.getBirthDate() != null){
        clientOnBank.setBirthDate(client.getBirthDate());
        }
        if(client.getAddress() != null){
            clientOnBank.setAddress(client.getAddress());
        }
        if (client.getTelephone()!= null){
            clientOnBank.setTelephone(client.getTelephone());
        }
        clientRepository.save(clientOnBank);
    }

    public void delete(long id){
        clientRepository.deleteById(id);
    }

    public List<Client> listAll()
    {
        return clientRepository.findAll();
    }
}
