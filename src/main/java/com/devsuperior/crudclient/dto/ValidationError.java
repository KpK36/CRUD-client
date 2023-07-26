package com.devsuperior.crudclient.dto;

import java.util.ArrayList;
import java.util.List;


public class ValidationError extends CustomError {

    List<FieldMessage> errors = new ArrayList<>();
    public ValidationError(Integer status, String error, String path) {
        super(status, error, path);
    }
    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message){
       errors.add(new FieldMessage(fieldName, message));

    }
}
