package awsspring.test.exception;

import org.springframework.http.HttpStatus;

public abstract class TestException extends RuntimeException{
    public TestException(String message) {
        super(message);
    }

    public abstract HttpStatus statusCode();
}