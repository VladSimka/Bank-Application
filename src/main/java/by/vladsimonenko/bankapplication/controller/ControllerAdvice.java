package by.vladsimonenko.bankapplication.controller;

import by.vladsimonenko.bankapplication.exception.ExceptionBody;
import by.vladsimonenko.bankapplication.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {


    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionBody resourceNotFound(ResourceNotFoundException e) {
        return new ExceptionBody(e.getMessage());
    }
}
