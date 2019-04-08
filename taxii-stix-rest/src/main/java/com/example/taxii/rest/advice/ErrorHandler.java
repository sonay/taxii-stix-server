package com.example.taxii.rest.advice;

import com.example.taxii.rest.api.datatypes.ErrorMessage;
import com.example.taxii.rest.exceptions.RequestedRangeUnsatisfiableException;
import com.example.taxii.rest.impl.objects.ErrorMessageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(RequestedRangeUnsatisfiableException.class)
    ResponseEntity<ErrorMessage> handlePaginationException(RequestedRangeUnsatisfiableException ex) {
        // TODO: fill the error
        ErrorMessage error = new ErrorMessageImpl();
        return new ResponseEntity<>(error, HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
    }

}
