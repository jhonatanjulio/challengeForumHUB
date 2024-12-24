package br.com.forumhub.infra.exception;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity sqlConstraintIntegrityViolation(SQLIntegrityConstraintViolationException ex) {
        return ResponseEntity.unprocessableEntity().body(ex.getMessage());
    }

    @ExceptionHandler(TopicAlreadyAnsweredException.class)
    public ResponseEntity topicAlreadyAnsweredHandler(TopicAlreadyAnsweredException ex) {
        return ResponseEntity.unprocessableEntity().body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity argumentNotValidHandler(MethodArgumentNotValidException ex) {
        var exception = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(exception.stream().map(ExceptionValidationData::new).toList());
    }

    @ExceptionHandler(UnauthorizedModificationException.class)
    public ResponseEntity unauthorizedModification(UnauthorizedModificationException ex) {
        return ResponseEntity.status(HttpStatusCode.valueOf(401)).body(ex.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity entityNotFound() {
        return ResponseEntity.notFound().build();
    }

    public record ExceptionValidationData(String campo, String mensagem) {
        public ExceptionValidationData(FieldError e) {
            this(e.getField(), e.getDefaultMessage());
        }
    }
}
