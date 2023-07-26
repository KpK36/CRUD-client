package com.devsuperior.crudclient.controller;

import com.devsuperior.crudclient.dto.ClientDTO;
import com.devsuperior.crudclient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
