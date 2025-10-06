package my.samples.springsecurity.web.controller;

import java.util.*;

import org.springframework.web.bind.annotation.*;

import my.samples.springsecurity.domain.user.*;

@RestController
public class SampleController {

    private final UserService userService;

    public SampleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserResponse> getAllUsers() {
        return userService.findAllUsers()
                          .stream()
                          .map(this::toUserResponse)
                          .sorted(Comparator.comparing(UserResponse::name))
                          .toList();
    }

    private UserResponse toUserResponse(User user) {
        return new UserResponse(user.getUserId(), user.getName());
    }

    private record UserResponse(long id, String name) { }
}
