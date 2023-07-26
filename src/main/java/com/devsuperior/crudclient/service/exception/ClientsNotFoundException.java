package com.devsuperior.crudclient.service.exception;

public class ClientsNotFoundException extends RuntimeException {
    public ClientsNotFoundException(String message) {
        super(message);
    }
}
