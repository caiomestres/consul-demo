package com.example.demo.ErrorStuff;

import lombok.Getter;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    private static final Logger LOGGERS = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({BusinessException.class})
    private ResponseEntity<Object> businessException(BusinessException ex){
//        HttpStatus httpStatus = ex instanceof AuthenticationException ? HttpStatus.UNAUTHORIZED : HttpStatus.BAD_REQUEST;
        LOGGERS.error(ex.getMessage(),ex);
        String userMessage = ex.getMessage();
        String technicalMessage = ExceptionUtils.getRootCauseMessage(ex) + " / " + ExceptionUtils.getStackTrace(ex);
        List<Error> errors = Collections.singletonList(new Error(userMessage, technicalMessage));
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, userMessage, errors);
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getHttpStatus());
    }

    @Getter
    static class Error {

        private String userMessage;
        private String technicalMessage;

        Error(String userMessage, String technicalMessage) {
            this.userMessage = userMessage;
            this.technicalMessage = technicalMessage;
        }
    }
}
