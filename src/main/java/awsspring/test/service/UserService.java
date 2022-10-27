package awsspring.test.service;

import awsspring.test.domain.User;
import awsspring.test.exception.TestNotFoundException;
import awsspring.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public Long join(User user){
        User save = userRepository.save(user);
        return save.getId();
    }
    public User findUser(Long id){
        return userRepository.findById(id).orElseThrow(() -> new TestNotFoundException("포스트를 찾을수 없습니다."));

    }

}
