package awsspring.test.service;

import awsspring.test.domain.User;
import awsspring.test.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static awsspring.test.testutil.TestEntityDataFactory.createUser;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @AfterEach
    void clear(){

    }

    @Test
    @DisplayName("유저 : 회원가입 테스트")
    public void join(){
        //given
        User user1 = createUser();
        //when
        userService.join(user1);

    }

    @Test
    @DisplayName("유저 : 회원가입 테스트")
    public void findUser(){
        //given
        User user1 = createUser();

        //when
        userService.join(user1);
        User savedUser = userService.findUser(user1.getId());
        //then
        assertThat(user1.getAge()).isEqualTo(savedUser.getAge());
        assertThat(user1.getUsername()).isEqualTo(savedUser.getUsername());
    }


}