package ai.chat.config;

import ai.chat.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ErrorResponse> handleException(RuntimeException ex) {

    System.err.println("An exception occurred: " + ex.getMessage());

    ErrorResponse response = ErrorResponse.builder()
        .status(HttpStatus.BAD_REQUEST).message(ex.getMessage()).build();
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }
}
