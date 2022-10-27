package awsspring.test.domain;

import awsspring.test.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import javax.validation.ConstraintViolationException;
import javax.validation.Validation;

import static awsspring.test.testutil.TestEntityDataFactory.createUser;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest {
    @Autowired
    private UserRepository userRepository;
    @AfterEach
    void clear() {
        userRepository.deleteAll();
    }
    @Test
    @DisplayName(value = "나이 최소 최대값 오류테스트")
    public void AgeTest() {
        User tester1 = createUser();
        userRepository.save(tester1);

    }
}