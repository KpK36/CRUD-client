package com.devsuperior.crudclient.service;

import com.devsuperior.crudclient.dto.ClientDTO;
import com.devsuperior.crudclient.entity.Client;
import com.devsuperior.crudclient.repository.ClientRespository;
import com.devsuperior.crudclient.service.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRespository clientRespository;
    @Transactional
    public Page<ClientDTO> findAll(Pageable pageable){
        return clientRespository.findAll(pageable).map(client -> new ClientDTO(client));

    }

    @Transactional
    public ClientDTO findById (Long id) {
        return new ClientDTO(clientRespository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id não encontrado")
        ));

    }

}
