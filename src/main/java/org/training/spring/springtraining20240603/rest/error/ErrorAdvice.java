package org.training.spring.springtraining20240603.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.util.stream.Collectors;
@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(IllegalArgumentException exp) {
        return new ErrorObj(null,
                            exp.getMessage(),
                            1024);
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorObj handleException(AccessDeniedException exp) {
        return new ErrorObj(null,
                            exp.getMessage(),
                            3000);
    }

    @ExceptionHandler(AuthorizationDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorObj handleException(AuthorizationDeniedException exp) {
        return new ErrorObj(null,
                            exp.getMessage(),
                            3000);
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ErrorObj handleException(IllegalStateException exp) {
        return new ErrorObj(null,
                            exp.getMessage(),
                            1025);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(MethodArgumentNotValidException exp) {

        return new ErrorObj(exp.getAllErrors()
                               .stream()
                               .map(se -> new ErrorObj(null,
                                                       se.toString(),
                                                       2000))
                               .collect(Collectors.toList()),
                            "validasyon problemi",
                            2001);
    }


    @ExceptionHandler(Exception.class)
    // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorObj> handleException(Exception exp) {
        System.err.println(exp.getMessage() + " : " + exp.getClass().getName());
        if (exp instanceof NullPointerException) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                                 .body(new ErrorObj(null,
                                                    exp.getMessage(),
                                                    5001));

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(new ErrorObj(null,
                                                exp.getMessage(),
                                                5001));
    }

}
