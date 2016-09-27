package com.nhnent.springmvc.helper;

import com.nhnent.springmvc.exception.UnAuthorizedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WebControllerAdvice {
    @ExceptionHandler(UnAuthorizedException.class)
    public ResponseEntity<Object> handlerUnAuthorizedException(UnAuthorizedException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/login");

        return new ResponseEntity<>(null, headers, HttpStatus.FOUND);
    }

}
