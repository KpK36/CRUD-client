package com.devsuperior.crudclient.controller.handler;

import com.devsuperior.crudclient.dto.CustomError;
import com.devsuperior.crudclient.dto.ValidationError;
import com.devsuperior.crudclient.service.exception.ClientsNotFoundException;
import com.devsuperior.crudclient.service.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;


import jakarta.validation.ConstraintViolation;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound (ResourceNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError error = new CustomError(status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
    @ExceptionHandler(ClientsNotFoundException.class)
    public ResponseEntity clientsNotFound () {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValid (MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError error = new ValidationError(status.value(), "Dados Inválidos", request.getRequestURI());

        for (FieldError f : e.getBindingResult().getFieldErrors()) {
            error.addError(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(error);

    }


}
