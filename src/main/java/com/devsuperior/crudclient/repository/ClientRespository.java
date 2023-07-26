package com.devsuperior.crudclient.repository;

import com.devsuperior.crudclient.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRespository extends JpaRepository<Client, Long> {
}
