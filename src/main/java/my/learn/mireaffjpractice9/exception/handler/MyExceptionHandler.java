package my.learn.mireaffjpractice9.exception.handler;

import my.learn.mireaffjpractice9.exception.AppException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleException(AuthenticationException exception) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("message", exception.getMessage());
        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleException(AppException exception) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("message", exception.getMessage());
        return new ResponseEntity<>(body, exception.getStatus());
    }

}
