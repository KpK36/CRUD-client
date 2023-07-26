package com.devsuperior.crudclient.dto;

import com.devsuperior.crudclient.entity.Client;

import java.time.LocalDate;

public class ClientDTO {

    private Long id;
    private String name;
    private String cpf;
    private Double income; // renda
    private LocalDate birthDate;
    private Integer children;

    public ClientDTO(Client client) {
        id = client.getId();
        name = client.getName();
        cpf = client.getCpf();
        income = client.getIncome();
        birthDate = client.getBirthDate();
        children = client.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
