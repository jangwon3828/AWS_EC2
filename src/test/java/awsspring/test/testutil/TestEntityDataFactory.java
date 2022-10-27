package awsspring.test.testutil;

import awsspring.test.domain.User;

public class TestEntityDataFactory {

    public static User createUser() {
        return User.builder()
                .username("username")
                .age(24)
                .build();
    }

}
