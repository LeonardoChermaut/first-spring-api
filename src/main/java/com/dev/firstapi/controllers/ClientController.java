package com.dev.firstapi.controllers;

import com.dev.firstapi.models.Client;
import com.dev.firstapi.resources.ClientResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    public ClientController(ClientResource clientResource) {
        this.clientResource = clientResource;
    }

    @Autowired
    ClientResource clientResource;

    @GetMapping("/listAll")
        public ResponseEntity<List<Client>> listAll() {
            return ResponseEntity.ok(clientResource.listAll());

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Client> findById(@PathVariable long id){
        return ResponseEntity.ok(clientResource.findId(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> saveClient(@PathVariable long id, @RequestBody Client client){
        clientResource.update(id, client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveClient(@RequestBody Client client){
        clientResource.saveClient(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> delete(@PathVariable long id){
            clientResource.delete(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
}
