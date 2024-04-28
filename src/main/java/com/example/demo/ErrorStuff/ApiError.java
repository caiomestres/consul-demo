package com.example.demo.ErrorStuff;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Getter
@Setter
public class ApiError {

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
  private final LocalDateTime dateTime;

  private final HttpStatus httpStatus;

  private final String message;

  private final List<GlobalExceptionHandler.Error> errors;

  public ApiError(HttpStatus httpStatus, String message, List<GlobalExceptionHandler.Error> errors) {

    this.dateTime = LocalDateTime.now(ZoneId.of(ZoneEnum.AMERICA_SAO_PAULO.getValue()));
    this.httpStatus = httpStatus;
    this.message = message;
    this.errors = errors;
  }
}
