package com.devsuperior.crudclient.controller;

import com.devsuperior.crudclient.dto.ClientDTO;
import com.devsuperior.crudclient.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable) {

        return ResponseEntity.ok(clientService.findAll(pageable));

    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById (@PathVariable Long id) {
        return ResponseEntity.ok(clientService.findById(id));

    }

    @PostMapping
    public ResponseEntity<ClientDTO> insert (@Valid @RequestBody ClientDTO clientDTO){

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(clientDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(clientService.insert(clientDTO));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update (@Valid @RequestBody ClientDTO clientDTO,
                                             @PathVariable Long id){

        return ResponseEntity.ok(clientService.update(id, clientDTO));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){

        clientService.delete(id);
        return ResponseEntity.ok().build();
    }

}
