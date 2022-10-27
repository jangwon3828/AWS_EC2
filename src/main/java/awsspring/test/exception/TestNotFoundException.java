package awsspring.test.exception;

import org.springframework.http.HttpStatus;

public class TestNotFoundException extends TestException {
    public TestNotFoundException(final String message) {
        super(message);
    }

    @Override
    public HttpStatus statusCode() {
        return HttpStatus.NOT_FOUND;
    }
}