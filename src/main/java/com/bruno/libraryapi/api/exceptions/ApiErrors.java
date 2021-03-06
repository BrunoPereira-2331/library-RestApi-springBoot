package com.bruno.libraryapi.api.exceptions;

import com.bruno.libraryapi.exceptions.BusinessException;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiErrors {

    private List<String> errors = new ArrayList<>();

    public ApiErrors(BindingResult bindingResult) {
        bindingResult.getAllErrors().forEach( error -> errors.add(error.getDefaultMessage()));
    }

    public ApiErrors(BusinessException exception) {
        this.errors = Arrays.asList(exception.getMessage());
    }

    public List<String> getErrors() {
        return errors;
    }
}
