package my.learn.mireaffjpractice9.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistException extends AppException{
    public UserAlreadyExistException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
