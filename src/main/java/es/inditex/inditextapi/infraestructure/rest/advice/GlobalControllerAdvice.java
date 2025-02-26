package es.inditex.inditextapi.infraestructure.rest.advice;

import es.inditex.inditextapi.infraestructure.adapter.exception.PriceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalControllerAdvice {
    private Map<String, Object> errorMap = new HashMap<>();

    @ExceptionHandler(PriceException.class)
    public ResponseEntity<Map<String, Object>> handleEmptyInput(PriceException emptyInputException) {
        errorMap.put("Status", "Error");
        errorMap.put("Message", emptyInputException.getErrorMessage());
        errorMap.put("Code", emptyInputException.getErrorCode());
        return new ResponseEntity<>(errorMap, emptyInputException.getErrorCode());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Map<String, Object>> badCredentials(BadCredentialsException exception){
        errorMap.put("Status", "Error");
        errorMap.put("Message", exception.getMessage());
        errorMap.put("Code", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorMap, HttpStatus.NOT_FOUND);
    }
}
