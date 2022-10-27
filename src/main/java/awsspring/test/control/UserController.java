package awsspring.test.control;

import awsspring.test.common.CommonResponse;
import awsspring.test.domain.User;
import awsspring.test.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody @Valid User user){
        Long userA = userService.join(user);
        return new ResponseEntity<>(CommonResponse.success(userA), HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        User userA = userService.findUser(id);
        return new ResponseEntity<>(CommonResponse.success(userA), HttpStatus.CREATED);
    }
}
