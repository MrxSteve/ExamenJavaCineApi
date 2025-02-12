package com.stevedev.cineapi.controllers.error;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

//@RestControllerAdvice
public class GlobalExceptionHandler {

    // COMENTE ESTO PORQUE SINO, NO DEJA ENTRAR EN SWAGGER
    // SI QUIERE PROBAR EL MANEJO DE EXCEPCIONES DESCOMENTELO Y LO PRUEBA CON POSTMAN
    // SI NO, DEJELO COMENTADO PARA QUE PUEDA SEGUIR USANDO SWAGGER
    // SE LO DEJO ASI PARA QUE SE LE HAGA MAS FACIL PROBAR LOS ENDPOINTS CON SWAGGER

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getFieldErrors().forEach(error ->
//                errors.put(error.getField(), error.getDefaultMessage())
//        );
//        return ResponseEntity.badRequest().body(errors);
//    }
//
//    @ExceptionHandler(EntityNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<Map<String, String>> handleEntityNotFoundException(EntityNotFoundException ex) {
//        Map<String, String> response = new HashMap<>();
//        response.put("error", ex.getMessage());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
//    }
//
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<Map<String, String>> handleInvalidFormatException(HttpMessageNotReadableException ex) {
//        Map<String, String> response = new HashMap<>();
//        response.put("error", "Formato de datos inválido");
//        return ResponseEntity.badRequest().body(response);
//    }
//
//    // EXCLUIR EXCEPCIONES DE SPRINGDOC PARA EVITAR EL ERROR EN SWAGGER
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseEntity<Map<String, String>> handleGeneralException(Exception ex) {
//        if (ex.getClass().getName().startsWith("org.springdoc")) {
//            return ResponseEntity.internalServerError().build();
//        }
//
//        Map<String, String> response = new HashMap<>();
//        response.put("error", "Error interno del servidor");
//        response.put("detalle", ex.getMessage());
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
//    }
}


