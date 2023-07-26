package com.devsuperior.crudclient.service;

import com.devsuperior.crudclient.dto.ClientDTO;
import com.devsuperior.crudclient.entity.Client;
import com.devsuperior.crudclient.repository.ClientRespository;
import com.devsuperior.crudclient.service.exception.ClientsNotFoundException;
import com.devsuperior.crudclient.service.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRespository clientRespository;
    @Transactional
    public Page<ClientDTO> findAll(Pageable pageable){

        if (clientRespository.findAll().isEmpty())
            throw new ClientsNotFoundException("Não foi cadastrado nenhum cliente");

        return clientRespository.findAll(pageable).map(ClientDTO::new);

    }

    @Transactional
    public ClientDTO findById (Long id) {
        return new ClientDTO(clientRespository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id não encontrado")
        ));

    }

    @Transactional
    public ClientDTO insert(ClientDTO clientDTO) {

        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setIncome(clientDTO.getIncome());
        client.setBirthDate(clientDTO.getBirthDate());
        client.setChildren(clientDTO.getChildren());

        return new ClientDTO(clientRespository.save(client));

    }

}
