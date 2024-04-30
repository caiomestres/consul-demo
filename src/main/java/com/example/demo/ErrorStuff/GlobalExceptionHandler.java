package com.example.demo.ErrorStuff;

import com.example.demo.ConsulConfig;
import lombok.Getter;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Object> handleBusinessException(BusinessException ex) {
        Integer statusCode = ExceptionMessageUtil.getExceptionDetails(ex.getIdentifier());
        HttpStatus status = statusCode != null && statusCode > 0 ?
            HttpStatus.valueOf(statusCode) :
            HttpStatus.BAD_REQUEST;
        ApiError apiError = new ApiError(
            status,
            ex.getMessage(),
            Collections.singletonList(new Error(ex.getMessage(), ex.getTechnicalMessage()))
        );
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
