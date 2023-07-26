package com.devsuperior.crudclient.service;

import ch.qos.logback.core.net.server.Client;
import com.devsuperior.crudclient.dto.ClientDTO;
import com.devsuperior.crudclient.repository.ClientRespository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRespository clientRespository;
    @Transactional
    public Page<ClientDTO> findAll(Pageable pageable){
        return clientRespository.findAll(pageable).map(client -> new ClientDTO(client));

    }

}
