package cl.duoc.cmartinez.authentication.controller;

import cl.duoc.cmartinez.authentication.service.exception.DuplicatedRegisterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class HandlerErrorController {
  @ExceptionHandler({DuplicatedRegisterException.class})
  public ResponseEntity<String> handleRuntimeException(DuplicatedRegisterException ex) {
    log.error(ex.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
  }
}
