package com.example.desafio_spring.advice;

import com.example.desafio_spring.advice.exception.ConflictException;
import com.example.desafio_spring.advice.exception.NotFoundException;
import com.example.desafio_spring.advice.exception.WriterValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class HandlerException extends Exception {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundException(NotFoundException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Not found!")
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timeStamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WriterValueException.class)
    public ResponseEntity<ExceptionDetails> handlerWriterValueException(WriterValueException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("File not saved!")
                .message(ex.getMessage())
                .status(HttpStatus.NOT_ACCEPTABLE.value())
                .timeStamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ExceptionDetails> handlerConflictException(ConflictException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Conflict!")
                .message(ex.getMessage())
                .status(HttpStatus.CONFLICT.value())
                .timeStamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(exceptionDetails, HttpStatus.CONFLICT);
    }
}
