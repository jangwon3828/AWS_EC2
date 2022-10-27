package awsspring.test.control;

import awsspring.test.common.CommonResponse;
import awsspring.test.common.ErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class TestAdvice {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> unexpectedException(final Exception e) {
        return new ResponseEntity<>(CommonResponse.fail(ErrorResponse.builder().errorCode(BAD_REQUEST)
                .errorMessage(e.getMessage()).build()), BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> unexpectedRuntimeException(final RuntimeException e) {
        return new ResponseEntity<>(CommonResponse.fail(ErrorResponse.builder().errorCode(BAD_REQUEST)
                .errorMessage(e.getMessage()).build()), BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        Map<String, String> validation = e.getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage));
        return new ResponseEntity<>(CommonResponse.fail(ErrorResponse.builder().errorCode(BAD_REQUEST)
                .errorMessage(validation.toString()).build()), BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> ConstraintViolationExceptionHandler(ConstraintViolationException e) {
        return new ResponseEntity<>(CommonResponse.fail(ErrorResponse.builder().errorCode(BAD_REQUEST)
                .errorMessage(e.getMessage()).build()), BAD_REQUEST);
    }
}

